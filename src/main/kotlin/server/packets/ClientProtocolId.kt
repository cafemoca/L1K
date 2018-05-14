package cm.moca.l1k.server.packets

import cm.moca.l1k.server.DotenvHelper

enum class ClientProtocolId(val value: Int) {

    CS_CLIENT_VERSION_INFO(DotenvHelper.load("CS_CLIENT_VERSION_INFO")),
    CS_STAT_RENEWAL_CALC_INFO_REQ(DotenvHelper.load("CS_STAT_RENEWAL_CALC_INFO_REQ")),
    ;

    companion object {
        private val map = ClientProtocolId.values().associateBy(ClientProtocolId::value)
        fun fromInt(type: Int): ClientProtocolId? {
            return map[type]
        }
    }

}
