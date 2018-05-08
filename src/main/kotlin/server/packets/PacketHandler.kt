package cm.moca.l1k.server.packets

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.packets.client.*

class PacketHandler(private val client: GameClient) {

    fun handlePacket(data: ByteArray) {
        val opcode = data[4].toInt() and 0xFF
        when (opcode) {
            _ClientOpcode.C_LOGIN.value -> AccountLogin(data, client)
            _ClientOpcode.C_CREATE_CUSTOM_CHARACTER.value -> CreateCharacter(data, client)
            _ClientOpcode.C_EXTENDED_PROTOBUF.value -> {
                val hb = data[5].toInt() and 0xFF
                val lb = data[6].toInt() and 0xFF
                val protocol = lb * 256 + hb
                when (protocol) {
                    _ClientProtocolId.CS_CLIENT_VERSION_INFO.value -> VersionCheck(data, client)
                    _ClientProtocolId.CS_STAT_RENEWAL_CALC_INFO_REQ.value -> CharStatCalculation(data, client)
                }
            }
        }
    }

}
