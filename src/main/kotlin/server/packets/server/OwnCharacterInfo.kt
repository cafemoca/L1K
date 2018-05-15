package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.ServerOpcode

class OwnCharacterInfo(character: PlayerCharacter) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_PUT_OBJECT.value)
        writeShort(32767)
        writeShort(32767)
        writeInt(character.id.value)
        writeShort(13733) // gfx
        writeByte(0) // status
        writeByte(0) // heading
        writeByte(0) // light range
        writeByte(1) // ?
        writeInt(0) // experience
        writeShort(0) // alignment
        writeString(character.characterName)
        writeString("") // title
        writeByte(0) // status?
        writeInt(0) // emblem
        writeString("") // ?
        writeString("") // ?
        writeByte(0xB0) // clan lank
        writeByte(0xFF) // party
        writeByte(0) // 3rd speed
        writeByte(0) // Lv? OR 海底波浪模糊程度 (官方應該已經棄用這功能了, 這數值只對自身有效果)
        writeByte(0) // C|S privateShopChatByte OR 物件的等級
        writeShort(0xFF) // ?
        writeShort(0xFF) // ?
        writeByte(0) // ?
        writeByte(0) //pc.getAttackLevelCount())
        //if (pc.isInParty()) {    // パーティー中
        //    var mpRatio = 100
        //    if (0 < pc.getMaxMp()) {
        //        mpRatio = 100 * pc.getCurrentMp() / pc.getMaxMp()
        //    }
        //    writeC(mpRatio)
        //} else {
        //    writeC(0xFF)
        //}
        writeByte(0xFF)
        writeShort(0)
    }

}