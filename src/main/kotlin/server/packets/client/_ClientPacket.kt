package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.packets._ServerOpcode
import cm.moca.l1k.server.packets._ClientProtocolId
import kotlinx.coroutines.experimental.io.ByteBuffer
import kotlinx.coroutines.experimental.launch
import java.nio.charset.Charset
import kotlin.math.min

abstract class _ClientPacket(data: ByteArray) {

    private val bs = ByteBuffer.wrap(data)

    var opcode: _ClientOpcode? = null
    var protocol: _ClientProtocolId? = null

    init {
        launch {
            bs.position(4)
            opcode = _ClientOpcode.fromInt(readByte())
            if (opcode == _ClientOpcode.C_EXTENDED_PROTOBUF) {
                protocol = _ClientProtocolId.fromInt(readShort())
            }
        }
    }

    fun reset() {
        bs.reset()
        skip(if (protocol != null) 7 else 5)
    }

    fun skip(skip: Int) {
        bs.position(bs.position() + if (protocol != null) 7 else 5)
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
        val hb = bs.get().toInt() and 0xFF
        val lb = bs.get().toInt() and 0xFF
        return lb * 256 + hb
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
    }

}
