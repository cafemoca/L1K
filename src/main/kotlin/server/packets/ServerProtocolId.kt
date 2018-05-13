package cm.moca.l1k.server.packets.server

enum class ServerProtocolId(val value: Int) {

    SC_SERVER_VERSION_INFO(0),
    ;

    companion object {
        private val map = ServerProtocolId.values().associateBy(ServerProtocolId::value)
        fun fromInt(type: Int): ServerProtocolId? {
            return map[type]
        }
    }

}
