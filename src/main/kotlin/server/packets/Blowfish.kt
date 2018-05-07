package cm.moca.l1k.server.packets

import kotlin.experimental.xor

class Blowfish(seed: Long) {

    private val eb: ByteArray
    private val db: ByteArray
    private val hb: ByteArray

    init {
        val keys = longArrayOf((seed xor key1), key2)
        keys[0] = (keys[0] rtl 13)
        keys[1] = keys[1] xor (keys[0] xor key3)
        val tb = (0..8).map { it.toByte() }.toByteArray()
        for (i in 0..1) {
            for (j in 0..3) {
                tb[i * 4 + j] = ((keys[i] shr j * 8) and 0xFF).toByte()
            }
        }
        eb = tb
        db = tb
        hb = (0..255).map { it.toByte() }.toByteArray()
        var t: Byte
        var temp = 0
        for (j in 0..255) {
            temp = (hb[j] + temp + eb[j % 8]) and 0xFF
            t = hb[temp]
            hb[temp] = hb[j]
            hb[j] = t
        }
    }

    fun decrypt(data: ByteArray): ByteArray {
        data[0] = data[0] xor (db[5] xor data[1])
        data[1] = data[1] xor (db[4] xor data[2])
        data[2] = data[2] xor (db[3] xor data[3])
        data[3] = data[3] xor db[2]
        val length = data.size
        for (i in length - 1 downTo 1) {
            data[i] = data[i] xor (data[i - 1] xor db[i and 7])
        }
        data[0] = data[0] xor db[0]
        update(db, data)
        return data
    }

    fun encrypt(data: ByteArray): ByteArray {
        val length = data.size + 1
        var b = 0
        var c: Int
        var d: Byte
        for (a in 1 until length) {
            b += hb[a % 256].toInt()
            b = b and 0xFF
            c = a and 0xFF
            d = hb[c]
            hb[c] = hb[b]
            hb[b] = d
            data[a - 1] = data[a - 1] xor hb[(hb[b] + hb[c]) and 0xFF]
        }
        return data
    }

    private fun update(data: ByteArray, ref: ByteArray) {
        for (i in 0..3) {
            data[i] = data[i] xor ref[i + 4]
        }
        val a = (
                (data[7].toInt() and 0xFF shl 24) or
                        (data[6].toInt() and 0xFF shl 16) or
                        (data[5].toInt() and 0xFF shl 8) or
                        (data[4].toInt() and 0xFF)) + key4
        for (i in 0..3) {
            data[i + 4] = (a shr i * 8 and 0xFF).toByte()
        }
    }

    private infix fun Long.rtl(n: Int): Long {
        return (this ushr n) or (this shl 32 - n)
    }

    companion object {
        private const val key1 = 0x9c30d539L
        private const val key2 = 0x930FD7E2L
        private const val key3 = 0x7C72E993L
        private const val key4 = 0x287EFFC3L
    }

}
