package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets._ClientProtocolId
import cm.moca.l1k.server.packets._ServerOpcode

class ServerVersionInfo : _ServerPacket() {

    init {
        val buildNumber = intArrayOf(0)
        val authVersion = intArrayOf(0)
        val gameRealTime = intArrayOf(0)
        val checkVersion = false
        val serverId = 0
        val countryCode = 4

        writeOpcode(_ServerOpcode.S_EXTENDED_PROTOBUF.value)
        writeShort(_ServerProtocolId.SC_SERVER_VERSION_INFO.value)

        writeByte(0x08)
        writeBoolean(checkVersion) //

        writeByte(0x10)
        writeByte(serverId) //

        writeByte(0x18)
        writeBytes(buildNumber) //

        writeByte(0x20)
        writeByte(0x00) //

        writeByte(0x28)
        writeBytes(authVersion) //

        writeByte(0x30)
        writeByte(0x00) //

        writeByte(0x38)
        writeByte(0x00) //

        writeByte(0x40)
        writeByte(0x00) //

        writeByte(0x48)
        writeByte(countryCode)

        writeByte(0x50)
        writeByte(0x00) //

        writeByte(0x58)
        writeBytes(gameRealTime) //

        writeByte(0x60)
        writeByte(0x00) //

        writeByte(0x68)
        writeByte(0x00) //

        writeByte(0x70)
        writeByte(0x00) //

        writeByte(0x78)
        writeByte(0x00) //

        writeByte(0x80)
        writeBytes(intArrayOf(0x01, 0x00)) //

        writeByte(0x88)
        writeByte(0x00) //
    }

}
