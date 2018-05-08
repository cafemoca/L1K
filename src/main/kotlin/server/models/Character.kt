package cm.moca.l1k.server.models

import cm.moca.l1k.server.datatables.Characters
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Character(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Character>(Characters)

    var account by Characters.account
    var characterName by Characters.characterName
    var level by Characters.level
    var highLevel by Characters.highLevel
    var experience by Characters.experience
    var currentHp by Characters.currentHp
    var maxHp by Characters.maxHp
    var currentMp by Characters.currentMp
    var maxMp by Characters.maxMp
    var armorClass by Characters.armorClass
    var magicResist by Characters.magicResist
    var statStr by Characters.statStr
    var baseStr by Characters.baseStr
    var statDex by Characters.statDex
    var baseDex by Characters.baseDex
    var statCon by Characters.statCon
    var baseCon by Characters.baseCon
    var statWis by Characters.statWis
    var baseWis by Characters.baseWis
    var statCha by Characters.statCha
    var baseCha by Characters.baseCha
    var statInt by Characters.statInt
    var baseInt by Characters.baseInt
    var gender by Characters.gender
    var classType by Characters.classType

}
