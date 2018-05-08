package cm.moca.l1k.server.controllers.status

class BasicStatus(classType: Int) {

    var statStr = 0
    var statDex = 0
    var statCon = 0
    var statWis = 0
    var statCha = 0
    var statInt = 0

    init {
        when (classType) {
            0 -> {
                statStr = 13
                statDex = 9
                statCon = 11
                statWis = 11
                statCha = 13
                statInt = 9
            }
            1 -> {
                statStr = 16
                statDex = 12
                statCon = 16
                statWis = 9
                statCha = 10
                statInt = 8
            }
            2 -> {
                statStr = 10
                statDex = 12
                statCon = 12
                statWis = 12
                statCha = 9
                statInt = 12
            }
            3 -> {
                statStr = 8
                statDex = 7
                statCon = 12
                statWis = 14
                statCha = 8
                statInt = 14
            }
            4 -> {
                statStr = 15
                statDex = 12
                statCon = 12
                statWis = 10
                statCha = 8
                statInt = 11
            }
            5 -> {
                statStr = 13
                statDex = 11
                statCon = 14
                statWis = 10
                statCha = 8
                statInt = 10
            }
            6 -> {
                statStr = 9
                statDex = 10
                statCon = 12
                statWis = 14
                statCha = 8
                statInt = 12
            }
            7 -> {
                statStr = 16
                statDex = 13
                statCon = 16
                statWis = 7
                statCha = 9
                statInt = 10
            }
        }
    }

}
