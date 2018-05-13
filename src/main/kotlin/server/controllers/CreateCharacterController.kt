package cm.moca.l1k.server.controllers

import cm.moca.l1k.server.datatables.PlayerCharacters
import cm.moca.l1k.server.models.accounts.Account
import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.models.statuses.BasicStat
import cm.moca.l1k.server.packets.server.CreateCharacterResult
import cm.moca.l1k.server.packets.server.NewCharacterInfo
import cm.moca.l1k.server.packets.server.ServerPacket
import cm.moca.l1k.server.packets.server.StatusModifierInfo
import org.jetbrains.exposed.sql.transactions.transaction

object CreateCharacterController {

    fun calcModifier(classType: Int, infoType: Int, stats: Map<BasicStat, Int>): Sequence<ServerPacket> {
        val str = stats[BasicStat.STR] ?: 0
        val con = stats[BasicStat.CON] ?: 0
        return stats.map {
            when {
                it.key == BasicStat.STR -> StatusModifierInfo(classType, infoType, it.key, it.value, con)
                it.key == BasicStat.DEX -> StatusModifierInfo(classType, infoType, it.key, it.value)
                it.key == BasicStat.CON -> StatusModifierInfo(classType, infoType, it.key, str, it.value)
                it.key == BasicStat.WIS -> StatusModifierInfo(classType, infoType, it.key, it.value)
                it.key == BasicStat.CHA -> StatusModifierInfo(classType, infoType, it.key, it.value)
                it.key == BasicStat.INT -> StatusModifierInfo(classType, infoType, it.key, it.value)
                else -> throw Exception()
            }
        }.asSequence()
    }

    fun createCharacter(account: Account, name: String, classType: Int, gender: Int, stats: Map<BasicStat, Int>): Sequence<ServerPacket> {
        if (name.isEmpty() || !name.matches(Regex("\\w+"))) {
            return sequenceOf(CreateCharacterResult(CreateCharacterResult.Reason.REASON_INVALID_NAME))
        }
        val exists = transaction { PlayerCharacter.find { PlayerCharacters.characterName eq name }.singleOrNull() }
        if (exists != null) {
            return sequenceOf((CreateCharacterResult(CreateCharacterResult.Reason.REASON_ALREADY_EXSISTS)))
        }

        val str = stats[BasicStat.STR] ?: 0
        val dex = stats[BasicStat.DEX] ?: 0
        val con = stats[BasicStat.CON] ?: 0
        val wis = stats[BasicStat.WIS] ?: 0
        val cha = stats[BasicStat.CHA] ?: 0
        val int = stats[BasicStat.INT] ?: 0

        val hp = StatusCalculator.calcBaseHp(con, classType)
        val mp = StatusCalculator.calcIncreaseMp(wis, classType)
        val ac = 10 + StatusCalculator.calcArmorClassModifier(dex)
        val mr = StatusCalculator.calcMagicResist(wis, classType)

        // TODO: check correct stats
        //val sum = str + dex + con + wis + cha + int
        //BasicStat.defaultStats[classType]?.values?.sum()

        val character = transaction {
            PlayerCharacter.new {
                this.accountId = account.id
                this.characterName = name
                this.level = 1
                this.highLevel = 1
                this.experience = 0
                this.currentHp = hp
                this.maxHp = hp
                this.currentMp = mp
                this.maxMp = mp
                this.armorClass = ac
                this.magicResist = mr
                this.statStr = str
                this.statDex = dex
                this.statCon = con
                this.statWis = wis
                this.statCha = cha
                this.statInt = int
                this.gender = gender
                this.classType = classType
            }
        }

        return sequenceOf(
                CreateCharacterResult(CreateCharacterResult.Reason.REASON_OK),
                NewCharacterInfo(character))
    }

}
