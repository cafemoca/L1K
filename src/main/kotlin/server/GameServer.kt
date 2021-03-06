package cm.moca.l1k.server

import cm.moca.l1k.server.datatables.Accounts
import cm.moca.l1k.server.datatables.PlayerCharacters
import io.ktor.network.sockets.aSocket
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction
import java.net.InetSocketAddress

object GameServer {

    var db: Database

    init {
        val user = "root"
        val password = ""
        val hostname = "localhost"
        val port = 3306
        val database = "l1kdb"
        val timezone = "JST"
        val encoding = "utf-8"
        val url = "jdbc:mysql://$hostname:$port/$database?useUnicode=true&serverTimezone=$timezone&characterEncoding=$encoding"
        val driver = "com.mysql.jdbc.Driver"
        db = Database.connect(url, driver, user, password)

        transaction {
            create(Accounts, PlayerCharacters)
        }

        run()
    }

    fun run() {
        runBlocking {
            val server = aSocket().tcp().bind(InetSocketAddress("127.0.0.1", 2000))
            while (true) {
                val socket = server.accept()
                launch {
                    val client = GameClient(socket)
                }
            }
        }
    }

}
