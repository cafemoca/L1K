package cm.moca.l1k.server.controllers

import cm.moca.l1k.server.datatables.Accounts
import cm.moca.l1k.server.datatables.PlayerCharacters
import cm.moca.l1k.server.models.accounts.Account
import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.server.CharacterCount
import cm.moca.l1k.server.packets.server.CharacterInfo
import cm.moca.l1k.server.packets.server.LoginResult
import cm.moca.l1k.server.packets.server.ServerPacket
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.sql.transactions.transaction

object AuthorizeController {

    fun find(accountName: String): Account? {
        return transaction {
            Account.find { Accounts.accountName eq accountName }.singleOrNull()
        }
    }

    fun auth(account: Account?, password: String): Sequence<ServerPacket> {
        return when (password) {
            account?.password -> success(account.id)
            else -> denied()
        }
    }

    private fun create(account: String, password: String): Account {
        return transaction {
            Account.new {
                this.accountName = account
                this.password = password
            }
        }
    }

    private fun success(id: EntityID<Int>): Sequence<ServerPacket> {
        var characters = transaction {
            PlayerCharacter.find { PlayerCharacters.accountId eq id }.toList()
        }
        val charCount = characters.size
        val maxSlot = 8
        println(charCount)
        return sequenceOf(
                LoginResult(LoginResult.Reason.REASON_LOGIN_OK),
                CharacterCount(charCount, maxSlot)) +
                characters.map { CharacterInfo(it) }
    }

    private fun denied(): Sequence<ServerPacket> {
        return sequenceOf(LoginResult(LoginResult.Reason.REASON_USER_OR_PASS_WRONG))
    }

}
