package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class BookmarkList : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_VOICE_CHAT.value)
        writeByte(42) // type
        writeByte(105) // size
        writeByte(0x00)
        writeByte(0x02)
        for (i in 0..20) {
            writeByte(i)
        }
        writeByte(0xFF)
        writeByte(100)
        writeByte(0)

        val count = 0
        writeByte(count)
        writeByte(0)
        //for (bookmark in bmlist) {
        //    writeH(bookmark.getLocX())
        //    writeH(bookmark.getLocY())
        //    writeS(bookmark.getName())
        //    writeH(bookmark.getMapId())  // mapid
        //    writeD(bookmark.getId())
        //}
    }

}
