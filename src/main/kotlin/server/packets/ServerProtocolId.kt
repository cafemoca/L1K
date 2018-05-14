package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.DotenvHelper

enum class ServerProtocolId(val value: Int) {

    SC_SERVER_VERSION_INFO(DotenvHelper.load("SC_SERVER_VERSION_INFO")),
    ;

    companion object {
        private val map = ServerProtocolId.values().associateBy(ServerProtocolId::value)
        fun fromInt(type: Int): ServerProtocolId? {
            return map[type]
        }
    }

}
