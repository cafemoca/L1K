package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.ServerOpcode

class CharacterStatusRefresh(character: PlayerCharacter) : ServerPacket() {

    init {
        writeByte(ServerOpcode.S_EXTENDED_PROTOBUF.value)
        writeByte(0xEA)
        writeByte(0x01)

        writeByte(0x08)
        writeByte(character.statStr)
        writeByte(0x10)
        writeByte(character.statInt)
        writeByte(0x18)
        writeByte(character.statWis)
        writeByte(0x20)
        writeByte(character.statDex)
        writeByte(0x28)
        writeByte(character.statCon)
        writeByte(0x30)
        writeByte(character.statCha)
        writeShort(0)
    }

}
