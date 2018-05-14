package cm.moca.l1k.server

import io.github.cdimascio.dotenv.dotenv

object DotenvHelper {

    val dotenv = dotenv()

    fun load(code: String): Int {
        return dotenv[code]?.toInt() ?: 0
    }

}
