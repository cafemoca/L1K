package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.controllers.CreateCharacterController
import cm.moca.l1k.server.models.statuses.BasicStat
import cm.moca.l1k.server.packets.PacketHandler
import kotlinx.coroutines.experimental.io.ByteBuffer

class StatusModifierCalculation(buffer: ByteBuffer) : ClientPacket(buffer) {

    var size = 0
    var level = 0
    var classType = 0
    var infoType = 0
    var stats = mutableMapOf<BasicStat, Int>()

    init {
        size = readShort()

        skip(1) // 08
        level = readByte()

        skip(1) // 10
        classType = readByte()

        skip(1) // 18
        infoType = readByte()

        for (i in 0 until (size - 6) / 2) {
            var key = readByte()
            when (key) {
                0x30 -> stats[BasicStat.STR] = readByte()
                0x38 -> stats[BasicStat.INT] = readByte()
                0x40 -> stats[BasicStat.WIS] = readByte()
                0x48 -> stats[BasicStat.DEX] = readByte()
                0x50 -> stats[BasicStat.CON] = readByte()
                0x58 -> stats[BasicStat.CHA] = readByte()
                //0xEA -> { } // reset
                //0xE7 -> { } // view
                else -> { skip(1) }
            }
        }
    }

    fun action(handler: PacketHandler) {
        CreateCharacterController.calcModifier(classType, infoType, stats).forEach { handler.send(it) }
    }

}
