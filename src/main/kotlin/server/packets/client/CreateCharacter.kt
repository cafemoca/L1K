package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.controllers.CalcStatController.calcArmorClassModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcBaseHp
import cm.moca.l1k.server.controllers.CalcStatController.calcIncreaseMp
import cm.moca.l1k.server.controllers.CalcStatController.calcMagicResist
import cm.moca.l1k.server.datatables.Characters.characterName
import cm.moca.l1k.server.models.Character
import cm.moca.l1k.server.packets.server.CreateCharacterResult
import kotlinx.coroutines.experimental.launch
import org.jetbrains.exposed.sql.transactions.transaction

class CreateCharacter(data: ByteArray, client: GameClient) : _ClientPacket(data) {

    init {
        launch {
            val name = readString().replace("\\s", "").replace("　", "")

            if (name.isEmpty()) {
                client.sendPacket(CreateCharacterResult(CreateCharacterResult.Reason.REASON_INVALID_NAME))
            }

            val exists = transaction { Character.find { characterName eq name }.singleOrNull() }
            if (exists != null) {
                client.sendPacket((CreateCharacterResult(CreateCharacterResult.Reason.REASON_ALREADY_EXSISTS)))
            }

            val c = readByte()
            val g = readByte()
            val str = readByte()
            val dex = readByte()
            val con = readByte()
            val wis = readByte()
            val cha = readByte()
            val int = readByte()

            val hp = calcBaseHp(con, c)
            val mp = calcIncreaseMp(wis, c)

            val ac = 10 + calcArmorClassModifier(dex)
            val mr = calcMagicResist(wis, c)

            // TODO: check correct stats

            transaction {
                Character.new {
                    account = client.account!!.id
                    characterName = name
                    level = 1
                    highLevel = 1
                    experience = 0
                    currentHp = hp
                    maxHp = hp
                    currentMp = mp
                    maxMp = mp
                    armorClass = ac
                    magicResist = mr
                    statStr = str
                    baseStr = str
                    statDex = dex
                    baseDex = dex
                    statCon = con
                    baseCon = con
                    statWis = wis
                    baseWis = wis
                    statCha = cha
                    baseCha = cha
                    statInt = int
                    baseInt = int
                    gender = g
                    classType = c
                }
            }
        }
    }

}
