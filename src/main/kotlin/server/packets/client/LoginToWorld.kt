package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.datatables.PlayerCharacters
import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.models.statuses.BasicStat
import cm.moca.l1k.server.packets.PacketHandler
import cm.moca.l1k.server.packets.server.*
import kotlinx.coroutines.experimental.io.ByteBuffer
import org.jetbrains.exposed.sql.transactions.transaction

class LoginToWorld(buffer: ByteBuffer) : ClientPacket(buffer) {

    val name: String = readString()

    fun action(handler: PacketHandler) {
        // とりあえずログイン処理を全部ここに書いておく（あとで整理する）
        val character = transaction {
            PlayerCharacter.find { PlayerCharacters.characterName eq name }.singleOrNull()
        }
        character!!
        handler.run {
            send(EnterToWorld(character))
            send(OwnCharacterStatus(character))
            send(MapInfo(4))
            send(OwnCharacterInfo(character))
            send(CharacterStatusRefresh(character))
            //send(CharacterStatusDetail(character))
            character.let {
                send(StatusModifierInfo(it.classType, 1, BasicStat.STR, it.statStr, it.statCon))
                send(StatusModifierInfo(it.classType, 1, BasicStat.INT, it.statInt))
                send(StatusModifierInfo(it.classType, 1, BasicStat.WIS, it.statWis))
                send(StatusModifierInfo(it.classType, 1, BasicStat.DEX, it.statDex))
                send(StatusModifierInfo(it.classType, 1, BasicStat.CON, it.statCon, it.statStr))
            }
            send(CharacterStatusBonus(25))
            send(CharacterStatusBonus(35))
            send(CharacterStatusBonus(45))
            send(Karma(0))
            send(PlayTime())
            send(BookmarkList())
            send(MagicStatus(character))
            send(CarryWeight(0, 0))
        }
    }

}
