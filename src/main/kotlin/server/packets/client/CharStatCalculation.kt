package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.controllers.status.BasicStatus
import cm.moca.l1k.server.packets.server.BaseStatInfo
import kotlinx.coroutines.experimental.launch
import java.math.BigInteger

class CharStatCalculation(data: ByteArray, client: GameClient) : _ClientPacket(data) {

    init {
        // ワールドにアクティブなキャラクターがいる場合はエラーにすべき

        launch {
            val size = readShort()

            readByte() // 08
            val level = readByte()

            readByte() // 10
            val classType = readByte()

            readByte() // 18
            val infoType = readByte()

            if (client.createCharStats == null) {
                client.createCharStats = BasicStatus(classType)
            }

            var hasStr = false
            var hasDex = false
            var hasCon = false
            var hasWis = false
            var hasCha = false
            var hasInt = false

            for (i in 0 until (size - 6) / 2) {
                var key = readByte()
                when (key) {
                    0x30 -> {
                        client.createCharStats?.statStr = readByte()
                        hasStr = true
                    }
                    0x38 -> {
                        client.createCharStats?.statInt = readByte()
                        hasInt = true
                    }
                    0x40 -> {
                        client.createCharStats?.statWis = readByte()
                        hasWis = true
                    }
                    0x48 -> {
                        client.createCharStats?.statDex = readByte()
                        hasDex = true
                    }
                    0x50 -> {
                        client.createCharStats?.statCon = readByte()
                        hasStr = true
                    }
                    0x58 -> {
                        client.createCharStats?.statCha = readByte()
                        hasCha = true
                    }
                    0xEA -> { } // reset
                    0xE7 -> { } // view
                }
            }

            if (hasStr) {
                client.sendPacket(BaseStatInfo(client.createCharStats, 1, classType, infoType))
                hasStr = false
            }
            if (hasInt) {
                client.sendPacket(BaseStatInfo(client.createCharStats, 2, classType, infoType))
                hasInt = false
            }
            if (hasWis) {
                client.sendPacket(BaseStatInfo(client.createCharStats, 3, classType, infoType))
                hasWis = false
            }
            if (hasDex) {
                client.sendPacket(BaseStatInfo(client.createCharStats, 4, classType, infoType))
                hasDex = false
            }
            if (hasCon) {
                client.sendPacket(BaseStatInfo(client.createCharStats, 5, classType, infoType))
                hasCon = false
            }
            if (hasCha) {
                client.sendPacket(BaseStatInfo(client.createCharStats, 6, classType, infoType))
                hasCha = false
            }
        }
    }

}
