package cm.moca.l1k.server.controllers

import java.util.Random

object CalcStatController {

    private val random = Random()

    fun calcDamageModifier(str: Int) : Int {
        return when (str) {
            in 0..9 -> 2
            10, 11 -> 3
            12, 13 -> 4
            14, 15 -> 5
            16, 17 -> 6
            18, 19 -> 7
            20, 21 -> 8
            22, 23 -> 9
            24 -> 10
            25 -> 11
            26, 27 -> 12
            28, 29 -> 13
            30, 31 -> 14
            32, 33 -> 15
            34 -> 16
            35 -> 17
            36, 37 -> 18
            38, 39 -> 19
            40, 41 -> 20
            42, 43 -> 21
            44 -> 22
            45, 46 -> 25
            47 -> 26
            48, 49 -> 27
            50 -> 28
            51, 52 -> 29
            53 -> 30
            54, 55 -> 31
            56 -> 32
            57, 58 -> 33
            59 -> 34
            60, 61 -> 35
            62 -> 36
            63, 64 -> 37
            else -> 38
        }
    }

    fun calcHitModifier(str: Int): Int {
        return when (str) {
            in 0..8 -> 5
            9, 10 -> 6
            11 -> 7
            12, 13 -> 8
            14 -> 9
            15, 16 -> 10
            17 -> 11
            18, 19 -> 12
            20 -> 13
            21, 22 -> 14
            23 -> 15
            24 -> 16
            25 -> 17
            26 -> 18
            27, 28 -> 19
            29 -> 20
            30, 31 -> 21
            32 -> 22
            33, 34 -> 23
            35 -> 25
            36, 37 -> 26
            38 -> 27
            39, 40 -> 28
            41 -> 29
            42, 43 -> 30
            44 -> 31
            45, 46 -> 35
            47 -> 36
            48, 49 -> 37
            50 -> 38
            51, 52 -> 39
            53 -> 40
            54, 55 -> 41
            56 -> 42
            57, 58 -> 43
            59 -> 44
            60, 61 -> 45
            62 -> 46
            63, 64 -> 47
            else -> 48
        }
    }

    fun calcCriticalDamageModifier(str: Int): Int {
        return when {
            str >= 65 -> 4
            str >= 55 -> 3
            str >= 45 -> 2
            str >= 40 -> 1
            else -> 0
        }
    }

    fun calcRangeDamageModifier(dex: Int): Int {
        return when (dex) {
            in 0..8 -> 2
            9, 10, 11 -> 3
            12, 13, 14 -> 4
            15, 16, 17 -> 5
            18, 19, 20 -> 6
            21, 22, 23 -> 7
            24 -> 8
            25, 26 -> 9
            27, 28, 29 -> 10
            30, 31, 32 -> 11
            33, 34 -> 12
            35 -> 13
            36, 37, 38 -> 14
            39, 40, 41 -> 15
            42, 43, 44 -> 16
            45, 46, 47 -> 20
            48, 49, 50 -> 21
            51, 52, 53 -> 22
            54, 55, 56 -> 23
            57, 58, 59 -> 24
            60, 61, 62 -> 25
            else -> 26
        }
    }

    fun calcRangeHitModifier(dex: Int): Int {
        return when (dex) {
            in 0..7 -> -3
            8 -> -2
            9 -> -1
            10 -> 0
            11 -> 1
            12 -> 2
            13 -> 3
            14 -> 4
            15 -> 5
            16 -> 6
            17 -> 7
            18 -> 8
            19 -> 9
            20 -> 10
            21 -> 11
            22 -> 12
            23 -> 13
            24 -> 14
            25 -> 16
            26 -> 17
            27 -> 18
            28 -> 19
            29 -> 20
            30 -> 21
            31 -> 22
            32 -> 23
            33 -> 24
            34 -> 25
            35 -> 27
            36 -> 28
            37 -> 29
            38 -> 30
            39 -> 31
            40 -> 32
            41 -> 33
            42 -> 34
            43 -> 35
            44 -> 36
            45 -> 38
            46 -> 39
            47 -> 40
            48 -> 41
            49 -> 42
            50 -> 43
            51 -> 44
            52 -> 45
            53 -> 46
            54 -> 47
            55 -> 49
            56 -> 50
            57 -> 51
            58 -> 52
            59 -> 53
            60 -> 54
            61 -> 55
            62 -> 56
            63 -> 57
            64 -> 58
            else -> 60
        }
    }

    fun calcRangeCriticalDamageModifier(dex: Int): Int {
        return when {
            dex >= 65 -> 4
            dex >= 55 -> 3
            dex >= 45 -> 2
            dex >= 40 -> 1
            else -> 0
        }
    }

    fun calcArmorClassModifier(dex: Int): Int {
        return when (dex) {
            in 0..8 -> -2
            in 9..65 -> -dex / 3
            else -> -31
        }
    }

    fun calcEvasionRate(dex: Int): Int {
        return when (dex) {
            in 0..7 -> 3
            in 8..43 -> dex / 2
            else -> 22
        }
    }

    fun calcMagicDamageModifier(int: Int): Int {
        return when (int) {
            in 0..14 -> 0
            in 15..19 -> 1
            in 20..24 -> 2
            in 25..29 -> 4
            in 30..34 -> 5
            in 35..39 -> 7
            in 40..44 -> 8
            in 45..49 -> 12
            in 50..54 -> 13
            in 55..59 -> 15
            in 60..64 -> 16
            else -> 18
        }
    }

    fun calcMagicHitModifier(int: Int): Int {
        return when (int) {
            in 0..8 -> -4
            9, 10, 11 -> -3
            12, 13, 14 -> -2
            15, 16, 17 -> -1
            18, 19, 20, 22 -> 0
            23, 24 -> 1
            25 -> 2
            26, 27, 28 -> 3
            29, 30, 31 -> 4
            32, 33, 34 -> 5
            35, 36, 37 -> 7
            38, 39, 40 -> 8
            41, 42, 43 -> 9
            44, 45, 46 -> 13
            47, 48, 49 -> 14
            50, 51, 52 -> 15
            53, 54, 55 -> 16
            56, 57, 58 -> 17
            59, 60, 61 -> 18
            62, 63, 64 -> 19
            else -> 20
        }
    }

    fun calcMagicCriticalModifier(int: Int): Int {
        return when {
            int >= 65 -> 6
            int >= 55 -> 5
            int >= 45 -> 4
            int >= 40 -> 2
            int >= 35 -> 1
            else -> 0
        }
    }

    fun calcMagicBonus(int: Int, classType: Int): Int {
        return if (classType == 3) {
            when(int) {
                in 0..15 -> 4
                in 16..65 -> int / 4 + 1
                else -> 16
            }
        } else {
            when (int) {
                in 0..10 -> 2
                in 11..15 -> 3
                in 16..17 -> 4
                in 18..23 -> 5
                in 24..27 -> 6
                in 28..31 -> 7
                in 32..35 -> 8
                in 36..39 -> 9
                in 40..43 -> 10
                in 44..47 -> 11
                in 48..51 -> 12
                in 52..55 -> 13
                in 56..59 -> 14
                in 60..63 -> 15
                else -> 16
            }
        }
    }

    fun calcDecreaseConsumeMp(int: Int): Int {
        return when (int) {
            in 0..8 -> 5
            9, 10 -> 6
            11 -> 7
            12, 13 -> 8
            14 -> 9
            15, 16 -> 10
            17 -> 11
            18, 19 -> 12
            20 -> 13
            21, 22 -> 14
            23 -> 15
            24, 25 -> 16
            26 -> 17
            27, 28 -> 18
            29 -> 19
            30, 31 -> 20
            32 -> 21
            33, 34 -> 22
            35 -> 23
            36, 37 -> 24
            38 -> 25
            39, 40 -> 26
            41 -> 27
            42, 43 -> 28
            44 -> 29
            45, 46 -> 30
            47 -> 31
            48, 49 -> 32
            50 -> 33
            51, 52 -> 34
            53 -> 35
            54, 55 -> 36
            56 -> 37
            57, 58 -> 38
            59 -> 39
            60, 61 -> 40
            62 -> 41
            63, 64 -> 42
            else -> 43
        }
    }

    fun calcIncreaseMp(wis: Int, type: Int): Int {
        return random.nextInt(calcMaxIncreaseMp(wis, type)) + calcMinIncreaseMp(wis, type)
    }

    fun calcMinIncreaseMp(wis: Int, type: Int): Int {
        when (type) {
            0 -> {
                return when {
                    wis <= 14 -> 3
                    wis <= 19 -> 4
                    wis <= 24 -> 5
                    wis <= 29 -> 6
                    wis <= 34 -> 7
                    wis <= 39 -> 8
                    wis <= 44 -> 9
                    else -> 10
                }
            }
            1, 7 -> {
                return when {
                    wis <= 9 -> 0
                    wis <= 14 -> 1
                    wis <= 24 -> 2
                    wis <= 28 -> 3
                    wis <= 39 -> 4
                    wis <= 44 -> 5
                    else -> 6
                }
            }
            2 -> {
                return when {
                    wis <= 14 -> 4
                    wis <= 19 -> 5
                    wis <= 24 -> 7
                    wis <= 29 -> 8
                    wis <= 34 -> 10
                    wis <= 39 -> 11
                    wis <= 44 -> 13
                    else -> 14
                }
            }
            3 -> {
                return when {
                    wis <= 14 -> 6
                    wis <= 19 -> 8
                    wis <= 24 -> 10
                    wis <= 29 -> 12
                    wis <= 34 -> 14
                    wis <= 39 -> 16
                    wis <= 44 -> 18
                    else -> 20
                }
            }
            4 -> {
                return when {
                    wis <= 14 -> 4
                    wis <= 19 -> 5
                    wis <= 24 -> 7
                    wis <= 29 -> 8
                    wis <= 34 -> 10
                    wis <= 39 -> 11
                    wis <= 44 -> 13
                    else -> 14
                }
            }
            5 -> {
                return when {
                    wis <= 14 -> 2
                    wis <= 24 -> 3
                    wis <= 29 -> 4
                    wis <= 39 -> 5
                    wis <= 44 -> 6
                    else -> 7
                }
            }
            6 -> {
                return when {
                    wis <= 14 -> 4
                    wis <= 19 -> 6
                    wis <= 24 -> 7
                    wis <= 29 -> 9
                    wis <= 34 -> 11
                    wis <= 39 -> 12
                    wis <= 44 -> 14
                    else -> 16
                }
            }
            else -> return 0
        }
    }

    fun calcMaxIncreaseMp(wis: Int, type: Int): Int {
        when (type) {
            0 -> {
                return when {
                    wis <= 11 -> 4
                    wis <= 14 -> 5
                    wis <= 17 -> 6
                    wis <= 20 -> 7
                    wis <= 23 -> 8
                    wis <= 26 -> 9
                    wis <= 29 -> 10
                    wis <= 32 -> 11
                    wis <= 35 -> 12
                    wis <= 38 -> 13
                    wis <= 41 -> 14
                    wis <= 44 -> 15
                    else -> 16
                }
            }
            1, 7 -> {
                return when {
                    wis <= 8 -> 1
                    wis <= 14 -> 2
                    wis <= 17 -> 3
                    wis <= 23 -> 4
                    wis <= 26 -> 5
                    wis <= 32 -> 6
                    wis <= 35 -> 7
                    wis <= 41 -> 8
                    wis <= 44 -> 9
                    else -> 10
                }
            }
            2 -> {
                return when {
                    wis <= 14 -> 7
                    wis <= 17 -> 8
                    wis <= 20 -> 10
                    wis <= 23 -> 11
                    wis <= 26 -> 13
                    wis <= 29 -> 14
                    wis <= 32 -> 16
                    wis <= 35 -> 17
                    wis <= 38 -> 19
                    wis <= 41 -> 20
                    wis <= 44 -> 22
                    else -> 23
                }
            }
            3 -> {
                return when {
                    wis <= 14 -> 10
                    wis <= 17 -> 12
                    wis <= 20 -> 14
                    wis <= 23 -> 16
                    wis <= 26 -> 18
                    wis <= 29 -> 20
                    wis <= 32 -> 22
                    wis <= 35 -> 24
                    wis <= 38 -> 26
                    wis <= 41 -> 28
                    wis <= 44 -> 30
                    else -> 32
                }
            }
            4 -> {
                return when {
                    wis <= 11 -> 5
                    wis <= 14 -> 7
                    wis <= 17 -> 8
                    wis <= 20 -> 10
                    wis <= 26 -> 13
                    wis <= 29 -> 14
                    wis <= 32 -> 16
                    wis <= 35 -> 17
                    wis <= 38 -> 19
                    wis <= 41 -> 20
                    else -> 22
                }
            }
            5 -> {
                return when {
                    wis <= 14 -> 3
                    wis <= 17 -> 4
                    wis <= 23 -> 5
                    wis <= 26 -> 6
                    wis <= 29 -> 7
                    wis <= 35 -> 8
                    wis <= 38 -> 9
                    wis <= 44 -> 10
                    else -> 11
                }
            }
            6 -> {
                return when {
                    wis <= 14 -> 7
                    wis <= 17 -> 9
                    wis <= 20 -> 11
                    wis <= 23 -> 12
                    wis <= 26 -> 14
                    wis <= 29 -> 16
                    wis <= 32 -> 18
                    wis <= 35 -> 19
                    wis <= 38 -> 21
                    wis <= 41 -> 23
                    wis <= 44 -> 24
                    else -> 26
                }
            }
            else -> return 0
        }
    }

    fun calcMpRegeneration(wis: Int): Int {
        return when (wis) {
            in 0..9 -> 1
            in 10..14 -> 2
            in 15..19 -> 3
            in 20..24 -> 4
            in 25..29 -> 6
            in 30..34 -> 7
            in 35..39 -> 9
            in 40..44 -> 10
            in 45..49 -> 14
            in 50..54 -> 15
            in 55..59 -> 16
            in 60..64 -> 17
            else -> 19
        }
    }

    fun calcMpRegenerationWithPotion(wis: Int): Int {
        return when (wis) {
            in 0..11 -> 1
            12, 13 -> 2
            14, 15 -> 3
            16, 17 -> 4
            18, 19 -> 6
            20, 21 -> 7
            22, 23 -> 8
            24, 25 -> 9
            26, 27 -> 10
            28, 29 -> 11
            30, 31 -> 12
            32, 33 -> 13
            34 -> 14
            35 -> 15
            36, 37 -> 16
            38, 39 -> 17
            40, 41 -> 18
            42, 43 -> 19
            44 -> 20
            45 -> 23
            46, 47 -> 24
            48, 49 -> 25
            50, 51 -> 26
            52, 53 -> 27
            54, 55 -> 28
            56, 57 -> 29
            58, 59 -> 30
            60, 61 -> 31
            62, 63 -> 32
            else -> 33
        }
    }

    fun calcMagicResist(wis: Int, type: Int): Int {
        when (type) {
            0 -> {
                return when (wis) {
                    in 11..65 -> 10 + (wis - 10) * 4
                    in 66..Int.MAX_VALUE -> 230
                    else -> 0
                }
            }
            1, 7 -> {
                return when (wis) {
                    in 11..65 -> (wis - 10) * 4
                    in 66..Int.MAX_VALUE -> 220
                    else -> 0
                }
            }
            2 -> {
                return when (wis) {
                    in 12..65 -> 25 + (wis - 10) * 4
                    in 66..Int.MAX_VALUE -> 245
                    else -> 0
                }
            }
            3 -> {
                return when (wis) {
                    in 14..65 -> 15 + (wis - 10) * 4
                    in 66..Int.MAX_VALUE -> 235
                    else -> 0
                }
            }
            4 -> {
                return when (wis) {
                    in 10..65 -> 10 + (wis - 10) * 4
                    in 66..Int.MAX_VALUE -> 230
                    else -> 0
                }
            }
            5 -> {
                return when (wis) {
                    in 10..65 -> 18 + (wis - 10) * 4
                    in 66..Int.MAX_VALUE -> 238
                    else -> 0
                }
            }
            6 -> {
                return when (wis) {
                    in 14..65 -> 20 + (wis - 10) * 4
                    in 66..Int.MAX_VALUE -> 240
                    else -> 0
                }
            }
            else -> return 0
        }
    }

    fun calcIncreaseHp(con: Int, type: Int): Int {
        var hp = when {
            con <= 12 -> 12 + random.nextInt(2)
            con <= 25 -> con + random.nextInt(2)
            con <= 26 -> 25 + random.nextInt(2)
            con <= 28 -> 26 + random.nextInt(2)
            con <= 30 -> 27 + random.nextInt(2)
            con <= 32 -> 28 + random.nextInt(2)
            con <= 34 -> 29 + random.nextInt(2)
            con <= 36 -> 30 + random.nextInt(2)
            con <= 38 -> 31 + random.nextInt(2)
            con <= 40 -> 32 + random.nextInt(2)
            con <= 42 -> 33 + random.nextInt(2)
            con <= 44 -> 34 + random.nextInt(2)
            con <= 46 -> 35 + random.nextInt(2)
            con <= 48 -> 36 + random.nextInt(2)
            con <= 50 -> 37 + random.nextInt(2)
            con <= 52 -> 38 + random.nextInt(2)
            con <= 54 -> 39 + random.nextInt(2)
            con <= 56 -> 40 + random.nextInt(2)
            con <= 58 -> 41 + random.nextInt(2)
            con <= 60 -> 42 + random.nextInt(2)
            con <= 62 -> 43 + random.nextInt(2)
            con <= 64 -> 44 + random.nextInt(2)
            else -> 45 + random.nextInt(2)
        }
        when (type) {
            1, 7 -> hp += 5
            2 -> hp -= 2
            3 -> hp -= 5
            4 -> hp -= 1
            5 -> hp += 1
            6 -> hp -= 3
        }
        return hp
    }

    fun calcHpRegeneration(con: Int): Int {
        return when (con) {
            12, 13 -> 6
            14, 15 -> 7
            16, 17 -> 8
            18, 19 -> 9
            20, 21 -> 10
            22, 23 -> 11
            24 -> 12
            25 -> 13
            26, 27 -> 14
            28, 29 -> 15
            30, 31 -> 16
            32, 33 -> 17
            34 -> 18
            35 -> 19
            36, 37 -> 20
            38, 39 -> 21
            40, 41 -> 22
            42, 43 -> 23
            44 -> 24
            45 -> 27
            46, 47 -> 28
            48, 49 -> 29
            50, 51 -> 30
            52, 53 -> 31
            54 -> 32
            55 -> 33
            56, 57 -> 34
            58, 59 -> 35
            60, 61 -> 36
            62, 63 -> 37
            64 -> 38
            else -> 39
        }
    }

    fun calcHpRegenerationWithPotion(con: Int): Int {
        return when (con) {
            in 0..19 -> 0
            in 20..29 -> 1
            in 30..34 -> 2
            in 35..39 -> 3
            in 40..44 -> 4
            in 45..49 -> 5
            in 50..54 -> 6
            in 55..59 -> 7
            in 60..64 -> 8
            else -> 9
        }
    }

    fun calcBaseHp(con: Int, type: Int): Int {
        var hp = when {
            con <= 12 -> 12
            con <= 25 -> con
            con <= 26 -> 25
            con <= 28 -> 26
            con <= 30 -> 27
            con <= 32 -> 28
            con <= 34 -> 29
            con <= 36 -> 30
            con <= 38 -> 31
            con <= 40 -> 32
            con <= 42 -> 33
            con <= 44 -> 34
            con <= 46 -> 35
            con <= 48 -> 36
            con <= 50 -> 37
            con <= 52 -> 38
            con <= 54 -> 39
            con <= 56 -> 40
            con <= 58 -> 41
            con <= 60 -> 42
            con <= 62 -> 43
            con <= 64 -> 44
            else -> 45
        }
        when (type) {
            1, 7 -> hp += 5
            2 -> hp -= 2
            3 -> hp -= 5
            4 -> hp -= 1
            5 -> hp += 1
            6 -> hp -= 3
        }
        return hp
    }

    fun calcMaxCarryWeight(str: Int, con: Int): Int {
        var total = str + con
        if (total > 150) {
            total = 150
        }
        if (total % 2 != 0) {
            total -= 1
        }
        return 1000 + total * 100
    }

    fun calcMagicBonus(int: Int): Int {
        return if (int < 12) 2 else 2 + (int - 8) / 4
    }

}
