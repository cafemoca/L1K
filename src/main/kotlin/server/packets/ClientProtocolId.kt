package cm.moca.l1k.server.packets

enum class ClientProtocolId(val value: Int) {

    CS_CLIENT_VERSION_INFO(0),
    CS_STAT_RENEWAL_CALC_INFO_REQ(0),
    ;

    companion object {
        private val map = ClientProtocolId.values().associateBy(ClientProtocolId::value)
        fun fromInt(type: Int): ClientProtocolId? {
            return map[type]
        }
    }

}
