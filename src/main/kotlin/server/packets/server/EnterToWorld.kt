package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.ServerOpcode

class EnterToWorld(character: PlayerCharacter) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_ENTER_WORLD_CHECK.value)
        writeByte(3)
        //if (character.bloodPledge > 0) {
        //    writeInt(character.id.value)
        //} else {
        writeByte(0x53)
        writeByte(0x01)
        writeByte(0x00)
        writeByte(0x8B)
        //}
        writeByte(0x9C)
        writeByte(0x1F)
    }

}
