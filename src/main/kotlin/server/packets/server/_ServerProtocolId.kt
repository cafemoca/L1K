package cm.moca.l1k.server.packets.server

enum class _ServerProtocolId(val value: Int) {

    SC_SERVER_VERSION_INFO(0),
    ;

    companion object {
        private val map = _ServerProtocolId.values().associateBy(_ServerProtocolId::value)
        fun fromInt(type: Int): _ServerProtocolId? {
            return map[type]
        }
    }

}
