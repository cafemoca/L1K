package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.controllers.CreateCharacterController
import cm.moca.l1k.server.models.statuses.BasicStat
import cm.moca.l1k.server.packets.PacketHandler
import kotlinx.coroutines.experimental.io.ByteBuffer
import kotlinx.coroutines.experimental.launch

class CreateCharacter(buffer: ByteBuffer) : ClientPacket(buffer) {

    private var name: String = ""
    private var classType: Int = 0
    private var gender: Int = 0
    private var stats = mutableMapOf<BasicStat, Int>()

    init {
        name = readString()
        classType = readByte()
        gender = readByte()
        stats[BasicStat.STR] = readByte()
        stats[BasicStat.DEX] = readByte()
        stats[BasicStat.CON] = readByte()
        stats[BasicStat.WIS] = readByte()
        stats[BasicStat.CHA] = readByte()
        stats[BasicStat.INT] = readByte()
    }

    fun action(handler: PacketHandler) {
        CreateCharacterController.createCharacter(handler.activeAccount!!, name, classType, gender, stats).forEach(handler::send)
    }

}
