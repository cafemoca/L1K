package cm.moca.l1k.server.packets.client

import io.ktor.cio.toByteReadChannel
import kotlinx.coroutines.experimental.io.readRemaining
import java.io.ByteArrayInputStream
import java.nio.charset.Charset

abstract class _ClientPacket(data: ByteArray) {

    private val bs = ByteArrayInputStream(data)
    private val br = bs.toByteReadChannel()

    init {
        bs.skip(OFFSET.toLong())
    }

    fun reset() {
        bs.reset()
    }

    fun skip(skip: Int) {
        bs.skip(skip.toLong())
    }

    suspend fun readInt(): Int {
        return br.readInt() and 0xFF
    }

    suspend fun readByte(): Int {
        return br.readByte().toInt() and 0xFF
    }

    suspend fun readBytes(length: Int): ByteArray {
        val temp = ByteArray(length)
        br.readAvailable(temp)
        return temp
    }

    suspend fun readBytes(): ByteArray {
        return readBytes(br.readRemaining().remaining)
    }

    suspend fun readShort(): Int {
        return br.readShort().toInt() and 0xFF
    }

    suspend fun readDouble(): Double {
        return br.readDouble()
    }

    suspend fun readString(): String {
        return readString(br.readRemaining().remaining)
    }

    suspend fun readString(length: Int): String {
        var d = readBytes(length)
        return String(d, 0, length, CLIENT_LANGUAGE_CODE)
    }

    companion object {
        private val CLIENT_LANGUAGE_CODE = Charset.forName("UTF-8")
        private val OFFSET = 5
    }

}
