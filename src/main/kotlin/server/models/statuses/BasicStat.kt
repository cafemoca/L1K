package cm.moca.l1k.server.models.statuses

enum class BasicStat(val value: Int) {

    STR(0),
    DEX(1),
    CON(2),
    WIS(3),
    INT(4),
    CHA(5),
    ;

    companion object {
        val defaultStats = mapOf(
                Pair(0, mapOf(
                    Pair(STR, 13),
                    Pair(DEX, 9),
                    Pair(CON, 11),
                    Pair(WIS, 11),
                    Pair(CHA, 13),
                    Pair(INT, 9))),
                Pair(1, mapOf(
                    Pair(STR, 16),
                    Pair(DEX, 12),
                    Pair(CON, 16),
                    Pair(WIS, 9),
                    Pair(CHA, 10),
                    Pair(INT, 8))),
                Pair(2, mapOf(
                    Pair(STR, 10),
                    Pair(DEX, 12),
                    Pair(CON, 12),
                    Pair(WIS, 12),
                    Pair(CHA, 9),
                    Pair(INT, 12))),
                Pair(3, mapOf(
                    Pair(STR, 8),
                    Pair(DEX, 7),
                    Pair(CON, 12),
                    Pair(WIS, 14),
                    Pair(CHA, 8),
                    Pair(INT, 14))),
                Pair(4, mapOf(
                    Pair(STR, 15),
                    Pair(DEX, 12),
                    Pair(CON, 12),
                    Pair(WIS, 10),
                    Pair(CHA, 8),
                    Pair(INT, 11))),
                Pair(5, mapOf(
                    Pair(STR, 13),
                    Pair(DEX, 11),
                    Pair(CON, 14),
                    Pair(WIS, 10),
                    Pair(CHA, 8),
                    Pair(INT, 10))),
                Pair(6, mapOf(
                    Pair(STR, 9),
                    Pair(DEX, 10),
                    Pair(CON, 12),
                    Pair(WIS, 14),
                    Pair(CHA, 8),
                    Pair(INT, 12))),
                Pair(7, mapOf(
                    Pair(STR, 16),
                    Pair(DEX, 13),
                    Pair(CON, 16),
                    Pair(WIS, 7),
                    Pair(CHA, 9),
                    Pair(INT, 10))))
    }

}
