package cm.moca.l1k.server.models.entities

import cm.moca.l1k.server.datatables.PlayerCharacters
import cm.moca.l1k.server.models.entities.EntityBase
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntityClass

open class PlayerCharacter(id: EntityID<Int>) : EntityBase(id) {

    companion object : IntEntityClass<PlayerCharacter>(PlayerCharacters)

    var accountId by PlayerCharacters.accountId
    var characterName by PlayerCharacters.characterName
    var level by PlayerCharacters.level
    var highLevel by PlayerCharacters.highLevel
    var experience by PlayerCharacters.experience
    var currentHp by PlayerCharacters.currentHp
    var maxHp by PlayerCharacters.maxHp
    var currentMp by PlayerCharacters.currentMp
    var maxMp by PlayerCharacters.maxMp
    var armorClass by PlayerCharacters.armorClass
    var magicResist by PlayerCharacters.magicResist
    var statStr by PlayerCharacters.statStr
    var statDex by PlayerCharacters.statDex
    var statCon by PlayerCharacters.statCon
    var statWis by PlayerCharacters.statWis
    var statCha by PlayerCharacters.statCha
    var statInt by PlayerCharacters.statInt
    var gender by PlayerCharacters.gender
    var classType by PlayerCharacters.classType

}
