package cm.moca.l1k.server.packets.client

import kotlinx.coroutines.experimental.io.ByteBuffer
import java.nio.charset.Charset
import kotlin.math.min

abstract class _ClientPacket(data: ByteArray) {

    private val bs = ByteBuffer.wrap(data)

    init {
        skip(OFFSET)
    }

    fun reset() {
        bs.reset()
        skip(OFFSET)
    }

    fun skip(skip: Int) {
        bs.position(bs.position() + OFFSET)
    }

    suspend fun readInt(): Int {
        return bs.int and 0xFF
    }

    suspend fun readByte(): Int {
        return bs.get().toInt() and 0xFF
    }

    suspend fun readBytes(length: Int): ByteArray {
        return _readBytes(min(bs.remaining(), length))
    }

    suspend fun readBytes(): ByteArray {
        return _readBytes(bs.remaining())
    }

    private suspend fun _readBytes(length: Int): ByteArray {
        val temp = ByteArray(length)
        bs.get(temp)
        return temp
    }

    suspend fun readShort(): Int {
        return bs.short.toInt() and 0xFF
    }

    suspend fun readDouble(): Double {
        return bs.double
    }

    suspend fun readString(): String {
        var d = byteArrayOf()
        var t: Byte
        while (bs.hasRemaining()) {
            t = bs.get()
            if (t == 0x00.toByte()) {
                break
            }
            d += t
        }
        return String(d, 0, d.size, CLIENT_LANGUAGE_CODE)
    }

    suspend fun readString(length: Int): String {
        var d = _readBytes(length)
        return String(d, 0, length, CLIENT_LANGUAGE_CODE)
    }

    companion object {
        private val CLIENT_LANGUAGE_CODE = Charset.forName("SJIS")
        private val OFFSET = 5
    }

}
