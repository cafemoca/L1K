package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.ServerOpcode

class NewCharacterInfo(character: PlayerCharacter) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_NEW_CHAR_INFO.value)
        writeString(character.characterName)
        writeString("") // clan name
        writeByte(character.classType)
        writeByte(character.gender)
        writeShort(0) // alignment
        writeShort(character.maxHp)
        writeShort(character.maxMp)
        writeByte(character.armorClass)
        writeByte(character.level)
        writeByte(character.statStr)
        writeByte(character.statDex)
        writeByte(character.statCon)
        writeByte(character.statWis)
        writeByte(character.statCha)
        writeByte(character.statInt)
        writeByte(0)
        writeInt(20000101) // birth day
        writeByte(character.level xor character.statStr xor character.statDex xor character.statCon xor character.statWis xor character.statCha xor character.statInt and 0xFF)
    }

}
