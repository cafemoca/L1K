package cm.moca.l1k.server.models.accounts

import cm.moca.l1k.server.datatables.Accounts
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Account(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Account>(Accounts)

    var accountName by Accounts.accountName
    var password by Accounts.password

}
