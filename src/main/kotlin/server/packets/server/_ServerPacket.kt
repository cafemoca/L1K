package cm.moca.l1k.server.packets.server

import java.io.ByteArrayOutputStream
import java.nio.charset.Charset

abstract class _ServerPacket {

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
        data.forEach {
            baos.write(it and 0xFF)
        }
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

    fun writeNumber(value: Int) {
        when {
            value <= 127 -> {
                this.baos.write(value and 0x7F)
            }
            value <= 16383 -> {
                this.baos.write(value and 0x7F or 0x80)
                this.baos.write(value shr 7 and 0x7F)
            }
            value <= 2097151 -> {
                this.baos.write(value and 0x7F or 0x80)
                this.baos.write(value shr 7 and 0x7F or 0x80)
                this.baos.write(value shr 14 and 0x7F)
            }
            value <= 268435455 -> {
                this.baos.write(value and 0x7F or 0x80)
                this.baos.write(value shr 7 and 0x7F or 0x80)
                this.baos.write(value shr 14 and 0x7F or 0x80)
                this.baos.write(value shr 21 and 0x7F)
            }
            value <= 34359738367L -> {
                this.baos.write(value and 0x7F or 0x80)
                this.baos.write(value shr 7 and 0x7F or 0x80)
                this.baos.write(value shr 14 and 0x7F or 0x80)
                this.baos.write(value shr 21 and 0x7F or 0x80)
                this.baos.write(value shr 28 and 0x7F)
            }
        }
    }

    fun clear() {
        baos?.reset()
        baos?.close()
    }

}
