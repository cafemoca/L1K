package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.controllers.StatusCalculator.calcArmorClassModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcBaseHp
import cm.moca.l1k.server.controllers.StatusCalculator.calcCriticalDamageModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcDamageModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcDecreaseConsumeMp
import cm.moca.l1k.server.controllers.StatusCalculator.calcEvasionRate
import cm.moca.l1k.server.controllers.StatusCalculator.calcHitModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcHpRegeneration
import cm.moca.l1k.server.controllers.StatusCalculator.calcHpRegenerationWithPotion
import cm.moca.l1k.server.controllers.StatusCalculator.calcMagicBonus
import cm.moca.l1k.server.controllers.StatusCalculator.calcMagicCriticalModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcMagicDamageModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcMagicHitModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcMagicResist
import cm.moca.l1k.server.controllers.StatusCalculator.calcMaxCarryWeight
import cm.moca.l1k.server.controllers.StatusCalculator.calcMaxIncreaseMp
import cm.moca.l1k.server.controllers.StatusCalculator.calcMinIncreaseMp
import cm.moca.l1k.server.controllers.StatusCalculator.calcMpRegeneration
import cm.moca.l1k.server.controllers.StatusCalculator.calcMpRegenerationWithPotion
import cm.moca.l1k.server.controllers.StatusCalculator.calcRangeCriticalDamageModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcRangeDamageModifier
import cm.moca.l1k.server.controllers.StatusCalculator.calcRangeHitModifier
import cm.moca.l1k.server.models.statuses.BasicStat
import cm.moca.l1k.server.packets.ServerOpcode

class StatusModifierInfo(classType: Int, infoType: Int, statType: BasicStat, statValue: Int, subValue: Int = 0) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_EXTENDED_PROTOBUF.value)
        writeByte(0xE3)
        writeByte(0x01)
        writeByte(0x08)
        writeByte(infoType * 2)

        when (statType) {
            BasicStat.STR -> {
                val strDmg = calcDamageModifier(statValue)
                val strHit = calcHitModifier(statValue)
                val strCrit = calcCriticalDamageModifier(statValue)
                val strWeight = calcMaxCarryWeight(statValue, subValue)
                val strSize = numberSizeOf(strDmg) + numberSizeOf(strHit) + numberSizeOf(strCrit) + numberSizeOf(strWeight) + 4
                writeByte(0x12)
                writeByte(strSize)
                writeByte(0x08)
                writeBigNumber(strDmg)
                writeByte(0x10)
                writeBigNumber(strHit)
                writeByte(0x18)
                writeBigNumber(strCrit)
                writeByte(0x20)
                writeBigNumber(strWeight)
            }
            BasicStat.INT -> {
                val intDmg = calcMagicDamageModifier(statValue)
                val intHit = calcMagicHitModifier(statValue)
                val intCrit = calcMagicCriticalModifier(statValue)
                val intMb = calcMagicBonus(statValue, classType)
                val intDecMp = calcDecreaseConsumeMp(statValue)
                val intSize = numberSizeOf(intDmg) + numberSizeOf(intHit) + numberSizeOf(intCrit) + numberSizeOf(intMb) + numberSizeOf(intDecMp) + 5
                writeByte(0x1A)
                writeByte(intSize)
                writeByte(0x08)
                writeBigNumber(intDmg)
                writeByte(0x10)
                writeBigNumber(intHit)
                writeByte(0x18)
                writeBigNumber(intCrit)
                writeByte(0x20)
                writeBigNumber(intMb)
                writeByte(0x28)
                writeBigNumber(intDecMp)
            }
            BasicStat.WIS -> {
                val wisMpr = calcMpRegeneration(statValue)
                val wisMprp = calcMpRegenerationWithPotion(statValue)
                val wisMr = calcMagicResist(statValue, classType)
                val wisMinMp = calcMinIncreaseMp(statValue, classType)
                val wisMaxMp = calcMaxIncreaseMp(statValue, classType)
                val wisSize = numberSizeOf(wisMpr) + numberSizeOf(wisMprp) + numberSizeOf(wisMr) + numberSizeOf(wisMinMp) + numberSizeOf(wisMaxMp) + 5
                writeByte(0x22)
                writeByte(wisSize)
                writeByte(0x08)
                writeBigNumber(wisMpr)
                writeByte(0x10)
                writeBigNumber(wisMprp)
                writeByte(0x18)
                writeBigNumber(wisMr)
                writeByte(0x20)
                writeBigNumber(wisMinMp)
                writeByte(0x28)
                writeBigNumber(wisMaxMp)
                writeByte(0x30)
                writeByte(0)
            }
            BasicStat.DEX -> {
                val dexDmg = calcRangeDamageModifier(statValue)
                val dexHit = calcRangeHitModifier(statValue)
                val dexCrit = calcRangeCriticalDamageModifier(statValue)
                val dexAc = calcArmorClassModifier(statValue)
                val dexEr = calcEvasionRate(statValue)
                val dexSize = numberSizeOf(dexDmg) + numberSizeOf(dexHit) + numberSizeOf(dexCrit) + numberSizeOf(dexAc) + numberSizeOf(dexEr) + 5
                writeByte(0x2A)
                writeByte(dexSize)
                writeByte(0x08)
                writeBigNumber(dexDmg)
                writeByte(0x10)
                writeBigNumber(dexHit)
                writeByte(0x18)
                writeBigNumber(dexCrit)
                writeByte(0x20)
                writeBigNumber(dexAc)
                writeByte(0x28)
                writeBigNumber(dexEr)
            }
            BasicStat.CON -> {
                val conHpr = calcHpRegeneration(statValue)
                val conHprp = calcHpRegenerationWithPotion(statValue)
                var conWeight = calcMaxCarryWeight(subValue, statValue)
                val conBaseHp = calcBaseHp(statValue, classType)
                val conSize = numberSizeOf(conHpr) + numberSizeOf(conHprp) + numberSizeOf(conWeight) + numberSizeOf(conBaseHp) + 4
                writeByte(0x32)
                writeByte(conSize)
                writeByte(0x08)
                writeBigNumber(conHpr)
                writeByte(0x10)
                writeBigNumber(conHprp)
                writeByte(0x18)
                writeBigNumber(conWeight)
                writeByte(0x20)
                writeBigNumber(conBaseHp)
                writeByte(0x28)
                writeByte(0)
            }
            BasicStat.CHA -> {
                writeShort(0x023A)
                writeShort(0x0108)
            }
        }
        writeShort(0)
    }

}
