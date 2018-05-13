package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.packets.ClientProtocolId
import kotlinx.coroutines.experimental.io.ByteBuffer
import kotlinx.coroutines.experimental.launch
import java.nio.charset.Charset
import kotlin.math.min

abstract class ClientPacket(private val buffer: ByteBuffer) {

    var opcode: ClientOpcode? = null
    var protocol: ClientProtocolId? = null

    init {
        buffer.position(4)
        opcode = ClientOpcode.fromInt(readByte() and 0xFF)
        if (opcode == ClientOpcode.C_EXTENDED_PROTOBUF) {
            protocol = ClientProtocolId.fromInt(readShort() and 0xFF)
        }
    }

    fun reset() {
        buffer.reset()
        skip(if (protocol != null) 7 else 5)
    }

    fun skip(skip: Int) {
        val newPosition = buffer.position() + skip
        buffer.position(if (newPosition < buffer.limit()) newPosition else buffer.limit())
    }

    fun readByte(): Int {
        return buffer.get().toInt() and 0xFF
    }

    fun readBytes(length: Int): ByteArray {
        return _readBytes(min(buffer.remaining(), length))
    }

    fun readBytes(): ByteArray {
        return _readBytes(buffer.remaining())
    }

    fun _readBytes(length: Int): ByteArray {
        val temp = ByteArray(length)
        buffer.get(temp)
        return temp
    }

    fun readInt(): Int {
        return buffer.int
    }

    fun readShort(): Int {
        return buffer.short.toInt()
    }

    fun readDouble(): Double {
        return buffer.double
    }

    fun readString(): String {
        val start = buffer.position()
        var dst = ByteArray(buffer.remaining())
        buffer.get(dst)
        return dst.let {
            val offset = it.indexOf(0x00)
            buffer.position(start + offset + 1)
            if (offset > 0)
                String(it.slice(0..(offset - 1)).toByteArray(), CLIENT_LANGUAGE_CODE)
            else
                ""
        }
    }

    fun readString(length: Int): String {
        var dst = _readBytes(length)
        return String(dst, 0, length, CLIENT_LANGUAGE_CODE)
    }

    companion object {
        private val CLIENT_LANGUAGE_CODE = Charset.forName("SJIS")
    }

}
