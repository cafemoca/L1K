package cm.moca.l1k.server.packets.server

import kotlinx.coroutines.experimental.io.ByteBuffer
import java.io.ByteArrayOutputStream
import java.math.BigInteger
import java.nio.charset.Charset

abstract class ServerPacket {

    protected val baos = ByteArrayOutputStream()

    val content: ByteArray get() = baos.toByteArray()
    val size: Int get() = baos.size()

    var opcode: Int? = null

    protected fun writeOpcode(value: Int) {
        opcode = value
        writeByte(value)
    }

    protected fun writeByte(value: Int) {
        baos.write(value and 0xFF)
    }

    protected fun writeInt(value: Int) {
        baos.write(value and 0xFF)
        baos.write(value shr 8 and 0xFF)
        baos.write(value shr 16 and 0xFF)
        baos.write(value shr 24 and 0xFF)
    }

    protected fun writeShort(value: Int) {
        baos.write(value and 0xFF)
        baos.write(value shr 8 and 0xFF)
    }

    protected fun writeBoolean(value: Boolean) {
        baos.write(if (value) 0x01 else 0x00)
    }

    protected fun writeBytes(data: ByteArray) {
        baos.write(data)
    }

    protected fun writeBytes(data: IntArray) {
        writeBytes(data.map { (it and 0xFF).toByte() }.toByteArray())
    }

    protected fun writeLong(value: Long) {
        baos.write((value and 0xFF).toInt())
    }

    protected fun writeString(text: String, charset: Charset = charset("UTF-8")) {
        baos.write(text.toByteArray(charset))
        baos.write(0x00) // '\0'
    }

    protected fun writeDouble(value: Double) {
        val d = java.lang.Double.doubleToLongBits(value)
        baos.write((d and 0xFF).toInt())
        baos.write((d shr 8 and 0xFF).toInt())
        baos.write((d shr 16 and 0xFF).toInt())
        baos.write((d shr 24 and 0xFF).toInt())
        baos.write((d shr 32 and 0xFF).toInt())
        baos.write((d shr 40 and 0xFF).toInt())
        baos.write((d shr 48 and 0xFF).toInt())
        baos.write((d shr 56 and 0xFF).toInt())
    }

    fun writeBigNumber(value: Int) {
        var i = 0
        while ((value.toBigInteger().and(bi).shiftRight((i + 1) * 7)).toLong() > 0) {
            baos.write(value.toBigInteger()
                    .and(bi)
                    .shiftRight(7 * i++)
                    .remainder(0x80.toBigInteger())
                    .or(0x80.toBigInteger())
                    .toInt())
        }
        baos.write(value.toBigInteger()
                .and(bi)
                .shiftRight(7 * i++)
                .remainder(0x80.toBigInteger())
                .toInt())
    }

    fun numberSizeOf(value: Int) : Int{
        var length = 0
        when {
            value < 0 -> {
                while (BigInteger.valueOf(value.toLong()).and(bi).shiftRight((length + 1) * 7).toLong() > 0) {
                    length++
                }
                length++
            }
            value <= 127 -> length = 1
            value <= 16383 -> length = 2
            value <= 2097151 -> length = 3
            value <= 268435455 -> length = 4
            value.toLong() <= 34359738367L -> length = 5
        }
        return length
    }

    fun writeNumber(value: Int) {
        when {
            value <= 127 -> {
                baos.write(value and 0x7F)
            }
            value <= 16383 -> {
                baos.write(value and 0x7F or 0x80)
                baos.write(value shr 7 and 0x7F)
            }
            value <= 2097151 -> {
                baos.write(value and 0x7F or 0x80)
                baos.write(value shr 7 and 0x7F or 0x80)
                baos.write(value shr 14 and 0x7F)
            }
            value <= 268435455 -> {
                baos.write(value and 0x7F or 0x80)
                baos.write(value shr 7 and 0x7F or 0x80)
                baos.write(value shr 14 and 0x7F or 0x80)
                baos.write(value shr 21 and 0x7F)
            }
            value <= 34359738367L -> {
                baos.write(value and 0x7F or 0x80)
                baos.write(value shr 7 and 0x7F or 0x80)
                baos.write(value shr 14 and 0x7F or 0x80)
                baos.write(value shr 21 and 0x7F or 0x80)
                baos.write(value shr 28 and 0x7F)
            }
        }
    }

    fun clear() {
        baos?.reset()
        baos?.close()
    }

    private fun ByteBuffer.putByte(value: Int) {
        this.put((value and 0xFF).toByte())
    }

    companion object {
        val bi = BigInteger("18446744073709551615")
    }

}
