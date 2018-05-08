package cm.moca.l1k.server.datatables

import org.jetbrains.exposed.dao.IntIdTable

object Accounts : IntIdTable("accounts") {

    val accountName = varchar("account_name", 32)
    val password = varchar("password", 128)

}
