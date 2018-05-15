package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.ServerOpcode

class OwnCharacterStatus(character: PlayerCharacter) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_STATUS.value)
        writeInt(character.id.value)
        writeByte(character.level)
        writeInt(character.experience)
        writeByte(character.statStr)
        writeByte(character.statInt)
        writeByte(character.statWis)
        writeByte(character.statDex)
        writeByte(character.statCon)
        writeByte(character.statCha)
        writeShort(character.currentHp)
        writeShort(character.maxHp)
        writeShort(character.currentMp)
        writeShort(character.maxMp)
        writeInt(character.armorClass)
        writeInt(0) //L1GameTimeClock.getInstance().getLastSendUtcSeconds())
        writeByte(0) //pc.getFood())
        writeByte(0) //IntRange.ensure(pc.getInventory().getWeight100(), 0, 100))
        writeShort(0) //pc.getLawful())
        writeShort(0) //IntRange.ensure(pc.getFire(), 0, 127))
        writeShort(0) //IntRange.ensure(pc.getWater(), 0, 127))
        writeShort(0) //IntRange.ensure(pc.getWind(), 0, 127))
        writeShort(0) //IntRange.ensure(pc.getEarth(), 0, 127))
        writeInt(0) //pc.getMonsterKill()) // 3.53C モンスター討伐数
    }

}
