package cm.moca.l1k.server.datatables

import org.jetbrains.exposed.dao.IntIdTable

object Characters : IntIdTable("characters") {

    val account = reference("account", Accounts)
    val characterName = varchar("character_name", 16)
    val level = integer("level")
    val highLevel = integer("high_level")
    val experience = integer("experience")
    val currentHp = integer("current_hp")
    val maxHp = integer("max_hp")
    val currentMp = integer("current_mp")
    val maxMp = integer("max_mp")
    val armorClass = integer("armor_class")
    val magicResist = integer("magic_resist")
    val statStr = integer("stat_str")
    val baseStr = integer("base_str")
    val statDex = integer("stat_dex")
    val baseDex = integer("base_dex")
    val statCon = integer("stat_con")
    val baseCon = integer("base_con")
    val statWis = integer("stat_wis")
    val baseWis = integer("base_wis")
    val statCha = integer("stat_cha")
    val baseCha = integer("base_cha")
    val statInt = integer("stat_int")
    val baseInt = integer("base_int")
    val gender = integer("gender")
    val classType = integer("class_type")

}
