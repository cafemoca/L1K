package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.controllers.AuthController
import cm.moca.l1k.server.packets.server.LoginResult
import kotlinx.coroutines.experimental.launch

class AccountLogin(data: ByteArray, client: GameClient) : _ClientPacket(data) {

    init {
        launch {
            val account = readString()
            val password = readString()
            AuthController.authorize(client, account, password)
        }
    }

}
