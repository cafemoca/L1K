package cm.moca.l1k.server.packets

enum class Opcode(val value: Int) {

    S_KEY(0),
    S_EXTENDED_PROTOBUF(0),
    S_LOGIN_CHECK(0),

    C_VERSION(0),
    C_LOGIN(0),
    C_EXTENDED_PROTOBUF(0),

}
