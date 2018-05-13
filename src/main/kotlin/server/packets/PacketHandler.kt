package cm.moca.l1k.server.packets

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.models.accounts.Account
import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.client.*
import cm.moca.l1k.server.packets.server.ServerPacket
import java.nio.ByteBuffer
import java.nio.ByteOrder

class PacketHandler(private val client: GameClient) {

    private var receiveCount = 0

    var activeAccount: Account? = null
    var activeCharacter: PlayerCharacter? = null

    fun receive(data: ByteArray) {
        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.LITTLE_ENDIAN)

        receiveCount++
        var header = buffer.int
        if (header != receiveCount) {
            // 不正なパケットが送信された可能性が高い
            println("receiveCount: $receiveCount, headerCount: $header")
        }

        val opcode = buffer.get().toInt() and 0xFF
        println("opcode: $opcode")
        when (opcode) {
            ClientOpcode.C_LOGIN.value -> AccountLogin(buffer).action(this)
            ClientOpcode.C_CREATE_CUSTOM_CHARACTER.value -> CreateCharacter(buffer).action(this)
            ClientOpcode.C_EXTENDED_PROTOBUF.value -> {
                val proto = buffer.short.toInt()
                println("protobuf: $proto")
                when (proto) {
                    ClientProtocolId.CS_CLIENT_VERSION_INFO.value -> VersionCheck(buffer).action(this)
                    ClientProtocolId.CS_STAT_RENEWAL_CALC_INFO_REQ.value -> StatusModifierCalculation(buffer).action(this)
                    else -> UnknownPacket(buffer)
                }
            }
            else -> UnknownPacket(buffer)
        }
    }

    fun send(serverPacket: ServerPacket) {
        client.send(serverPacket)
    }

    fun activateAccount(account: Account) {
        this.activeAccount = account
    }

    fun deactivateAccount() {
        this.activeAccount = null
        this.activeCharacter = null
    }

    fun activateCharacter(character: PlayerCharacter) {
        this.activeCharacter = character
    }

    fun deactivateCharacter() {
        this.activeCharacter = null
    }

}
