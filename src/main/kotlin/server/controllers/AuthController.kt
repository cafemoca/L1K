package cm.moca.l1k.server.controllers

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.datatables.Accounts
import cm.moca.l1k.server.models.Account
import cm.moca.l1k.server.packets.server.CharacterCount
import cm.moca.l1k.server.packets.server.LoginResult
import org.jetbrains.exposed.sql.transactions.transaction

object AuthController {

    fun authorize(client: GameClient, ac: String, pw: String) {
        transaction {
            var account = Account.find { Accounts.accountName eq ac }.singleOrNull()
            if (account == null) {
                account = create(ac, pw)
                success(client, account)
            } else {
                if (account.password == pw) {
                    success(client, account)
                } else {
                    denied(client)
                }
            }
        }
    }

    fun create(ac: String, pw: String): Account {
        return Account.new {
            accountName = ac
            password = pw
        }
    }

    fun success(client: GameClient, account: Account) {
        client.sendPacket(LoginResult(LoginResult.Reason.REASON_LOGIN_OK))
        client.sendPacket(CharacterCount(0, 4))
        client.account = account
    }

    fun denied(client: GameClient) {
        client.sendPacket(LoginResult(LoginResult.Reason.REASON_USER_OR_PASS_WRONG))
    }

}
