package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.models.entities.PlayerCharacter
import cm.moca.l1k.server.packets.ServerOpcode

class MagicStatus(character: PlayerCharacter) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_MAGIC_STATUS.value)
        writeShort(0)
        writeShort(0)
        // ウィズダムポーションのSPはS_SkillBrave送信時に更新されるため差し引いておく
        //if (pc.hasSkillEffect(STATUS_WISDOM_POTION)) {
        //    writeH(pc.getSp() - pc.getTrueSp() - 2) // 装備増加したSP
        //} else {
        //    writeH(pc.getSp() - pc.getTrueSp()) // 装備増加したSP
        //}
        //writeH(pc.getMr() - pc.getBaseMr()) // 装備や魔法で増加したMR
    }

}
