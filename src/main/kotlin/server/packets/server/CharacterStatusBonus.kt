package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class CharacterStatusBonus(value: Int) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_EXTENDED_PROTOBUF.value)
        writeByte(0xE7)
        writeByte(0x01)

        writeByte(0x0a)// 力
        writeByte(if (value == 45) 8 else 6)
        writeByte(0x08)
        writeByte(value)// レベル
        writeByte(0x10)
        writeByte(if (value == 45) 3 else 1)// 近距離ダメージ
        writeByte(0x18)
        writeByte(if (value == 45) 3 else 1)// 近距離命中
        if (value == 45) {
            writeByte(0x20)
            writeByte(1)// 近距離クリティカル
        }
        writeByte(0x12)// ポイント
        writeByte(if (value == 45) 8 else 6)
        writeByte(0x08)
        writeByte(value)// レベル
        writeByte(0x10)
        writeByte(if (value == 45) 3 else 1)// 魔法ダメージ
        writeByte(0x18)
        writeByte(if (value == 45) 3 else 1)// 魔法命中
        if (value == 45) {
            writeByte(0x20)
            writeByte(1)// 魔法クリティカル
        }
        writeByte(0x1a)// ウィズ
        writeByte(if (value == 45) 9 else 8)
        writeByte(0x08)
        writeByte(value)// レベル
        writeByte(0x10)
        writeByte(if (value == 45) 3 else 1)// エムチク
        writeByte(0x18)
        writeByte(if (value == 45) 3 else 1)// ポーション回復増加
        writeByte(0x38)
        writeByte(if (value == 45) 150 else if (value == 35) 100 else 50)// エム50 100 150
        if (value == 45) {
            writeByte(1)// ペナルティ緩和
        }
        writeByte(0x22)// デス
        writeByte(if (value == 45) 8 else 6)
        writeByte(0x08)
        writeByte(value)// レベル
        writeByte(0x10)
        writeByte(if (value == 45) 3 else 1)// 遠距離ダメージ
        writeByte(0x18)
        writeByte(if (value == 45) 3 else 1)// 遠距離命中
        if (value == 45) {
            writeByte(0x20)
            writeByte(1)// 遠距離クリティカル
        }
        writeByte(0x2a)// コーン
        writeByte(if (value == 45) 9 else if (value == 35) 8 else 6)
        writeByte(0x08)
        writeByte(value)// レベル
        writeByte(0x10)
        writeByte(if (value == 45) 3 else 1)// ピチク
        if (value != 25) {
            writeByte(0x18)
            writeByte(if (value == 35) 1 else 2)// ポーション回復増加
        }
        writeByte(0x30)
        writeByte(if (value == 45) 150 else if (value == 35) 100 else 50)// 被50 100 150
        if (value == 45) {
            writeByte(1)// ペナルティ緩和
        }
        writeShort(0x0B32)
        writeByte(0x08)
        writeInt(-1)
        writeInt(-1)
        writeShort(0x01FF)
        writeShort(0)
    }

}
