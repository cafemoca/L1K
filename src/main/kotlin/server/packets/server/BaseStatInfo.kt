package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.controllers.CalcStatController.calcArmorClassModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcBaseHp
import cm.moca.l1k.server.controllers.CalcStatController.calcCriticalDamageModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcDamageModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcDecreaseConsumeMp
import cm.moca.l1k.server.controllers.CalcStatController.calcEvasionRate
import cm.moca.l1k.server.controllers.CalcStatController.calcHitModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcHpRegeneration
import cm.moca.l1k.server.controllers.CalcStatController.calcHpRegenerationWithPotion
import cm.moca.l1k.server.controllers.CalcStatController.calcMagicBonus
import cm.moca.l1k.server.controllers.CalcStatController.calcMagicCriticalModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcMagicDamageModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcMagicHitModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcMagicResist
import cm.moca.l1k.server.controllers.CalcStatController.calcMaxCarryWeight
import cm.moca.l1k.server.controllers.CalcStatController.calcMaxIncreaseMp
import cm.moca.l1k.server.controllers.CalcStatController.calcMinIncreaseMp
import cm.moca.l1k.server.controllers.CalcStatController.calcMpRegeneration
import cm.moca.l1k.server.controllers.CalcStatController.calcMpRegenerationWithPotion
import cm.moca.l1k.server.controllers.CalcStatController.calcRangeCriticalDamageModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcRangeDamageModifier
import cm.moca.l1k.server.controllers.CalcStatController.calcRangeHitModifier
import cm.moca.l1k.server.controllers.status.BasicStatus
import cm.moca.l1k.server.packets._ServerOpcode
import java.math.BigInteger

class BaseStatInfo(stats: BasicStatus?, statType: Int, classType: Int, infoType: Int) : _ServerPacket() {

    init {
        writeOpcode(_ServerOpcode.S_EXTENDED_PROTOBUF.value)
        writeByte(0xE3)
        writeByte(0x01)
        writeByte(0x08)
        writeByte(infoType * 2)

        stats!!
        when (statType) {
            1 -> {
                val strDmg = calcDamageModifier(stats.statStr)
                val strHit = calcHitModifier(stats.statStr)
                val strCrit = calcCriticalDamageModifier(stats.statStr)
                val strWeight = calcMaxCarryWeight(stats.statStr, stats.statCon)
                val strSize = numberSizeOf(strDmg) + numberSizeOf(strHit) + numberSizeOf(strCrit) + numberSizeOf(strWeight) + 4
                writeByte(0x12)
                writeByte(strSize)
                writeByte(0x08)
                writeNumber(strDmg)
                writeByte(0x10)
                writeNumber(strHit)
                writeByte(0x18)
                writeNumber(strCrit)
                writeByte(0x20)
                writeNumber(strWeight)
            }
            2 -> {
                val intDmg = calcMagicDamageModifier(stats.statInt)
                val intHit = calcMagicHitModifier(stats.statInt)
                val intCrit = calcMagicCriticalModifier(stats.statInt)
                val intMb = calcMagicBonus(stats.statInt, classType)
                val intDecMp = calcDecreaseConsumeMp(stats.statInt)
                val intSize = numberSizeOf(intDmg) + numberSizeOf(intHit) + numberSizeOf(intCrit) + numberSizeOf(intMb) + numberSizeOf(intDecMp) + 5
                writeByte(0x1A)
                writeByte(intSize)
                writeByte(0x08)
                writeNumber(intDmg)
                writeByte(0x10)
                writeNumber(intHit)
                writeByte(0x18)
                writeNumber(intCrit)
                writeByte(0x20)
                writeNumber(intMb)
                writeByte(0x28)
                writeNumber(intDecMp)
            }
            3 -> {
                val wisMpr = calcMpRegeneration(stats.statWis)
                val wisMprp = calcMpRegenerationWithPotion(stats.statWis)
                val wisMr = calcMagicResist(stats.statWis, classType)
                val wisMinMp = calcMinIncreaseMp(stats.statWis, classType)
                val wisMaxMp = calcMaxIncreaseMp(stats.statWis, classType)
                val wisSize = numberSizeOf(wisMpr) + numberSizeOf(wisMprp) + numberSizeOf(wisMr) + numberSizeOf(wisMinMp) + numberSizeOf(wisMaxMp) + 5
                writeByte(0x22)
                writeByte(wisSize)
                writeByte(0x08)
                writeNumber(wisMpr)
                writeByte(0x10)
                writeNumber(wisMprp)
                writeByte(0x18)
                writeNumber(wisMr)
                writeByte(0x20)
                writeNumber(wisMinMp)
                writeByte(0x28)
                writeNumber(wisMaxMp)
                writeByte(0x30)
                writeByte(0)
            }
            4 -> {
                val dexDmg = calcRangeDamageModifier(stats.statDex)
                val dexHit = calcRangeHitModifier(stats.statDex)
                val dexCrit = calcRangeCriticalDamageModifier(stats.statDex)
                val dexAc = calcArmorClassModifier(stats.statDex)
                val dexEr = calcEvasionRate(stats.statDex)
                val dexSize = numberSizeOf(dexDmg) + numberSizeOf(dexHit) + numberSizeOf(dexCrit) + numberSizeOf(dexAc) + numberSizeOf(dexEr) + 5
                writeByte(0x2A)
                writeByte(dexSize)
                writeByte(0x08)
                writeNumber(dexDmg)
                writeByte(0x10)
                writeNumber(dexHit)
                writeByte(0x18)
                writeNumber(dexCrit)
                writeByte(0x20)
                writeNumber(dexAc)
                writeByte(0x28)
                writeNumber(dexEr)
            }
            5 -> {
                val conHpr = calcHpRegeneration(stats.statCon)
                val conHprp = calcHpRegenerationWithPotion(stats.statCon)
                var conWeight = calcMaxCarryWeight(stats.statStr, stats.statCon)
                val conBaseHp = calcBaseHp(stats.statCon, classType)
                val conSize = numberSizeOf(conHpr) + numberSizeOf(conHprp) + numberSizeOf(conWeight) + numberSizeOf(conBaseHp) + 4
                writeByte(0x32)
                writeByte(conSize)
                writeByte(0x08)
                writeNumber(conHpr)
                writeByte(0x10)
                writeNumber(conHprp)
                writeByte(0x18)
                writeNumber(conWeight)
                writeByte(0x20)
                writeNumber(conBaseHp)
                writeByte(0x28)
                writeByte(0)
            }
            6 -> {
                writeShort(0x023A)
                writeShort(0x0108)
            }
            else -> {
            }
        }
        writeShort(0x00)
    }

    private fun numberSizeOf(value: Int) : Int{
        var length = 0
        when {
            value < 0 -> {
                val b = BigInteger("18446744073709551615")
                while (BigInteger.valueOf(value.toLong()).and(b).shiftRight((length + 1) * 7).toLong() > 0) {
                    length++
                }
                length++
            }
            value <= 127 -> length = 1
            value <= 16383 -> length = 2
            value <= 2097151 -> length = 3
            value <= 268435455 -> length = 4
            value.toLong() <= 34359738367L -> length = 5
        }
        return length
    }

}
