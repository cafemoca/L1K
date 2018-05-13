package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class LoginResult(reason: Reason) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_LOGIN_CHECK.value)
        writeByte(reason.value)
        writeInt(0)
        writeInt(0)
        writeInt(0)
    }

    enum class Reason(val value: Int) {
        REASON_LOGIN_OK(0x00),
        REASON_ACCOUNT_IN_USE(0x16),
        REASON_ACCOUNT_ALREADY_EXISTS(0x26),
        REASON_ACCESS_FAILED(0x08),
        REASON_USER_OR_PASS_WRONG(0x08),
        REASON_BUG_WRONG(0x39),
        REASON_WRONG_ACCOUNT(0x09),
        REASON_WRONG_PASSWORD(0x0A),
    }

}
