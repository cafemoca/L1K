package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.controllers.AuthorizeController
import cm.moca.l1k.server.packets.PacketHandler
import java.nio.ByteBuffer

class AccountLogin(buffer: ByteBuffer) : ClientPacket(buffer) {

    private var account: String = ""
    private var password: String = ""

    init {
        account = readString()
        password = readString()
    }

    fun action(handler: PacketHandler) {
        val account = AuthorizeController.find(account)
        AuthorizeController.auth(account, password).forEach(handler::send)
        if (account != null) {
            handler.activateAccount(account)
        }
    }

}
