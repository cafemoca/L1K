package cm.moca.l1k.server.packets

import cm.moca.l1k.server.DotenvHelper

enum class ServerOpcode(val value: Int) {

    S_ABILITY_SCORES(DotenvHelper.load("S_ABILITY_SCORES")),
    S_AC(DotenvHelper.load("S_AC")),
    S_ACTION(DotenvHelper.load("S_ACTION")),
    S_ADD_BOOKMARK(DotenvHelper.load("S_ADD_BOOKMARK")),
    S_ADD_INVENTORY(DotenvHelper.load("S_ADD_INVENTORY")),
    S_ADD_INVENTORY_BATCH(DotenvHelper.load("S_ADD_INVENTORY_BATCH")),
    S_ADD_SPELL(DotenvHelper.load("S_ADD_SPELL")),
    S_ADD_XCHG(DotenvHelper.load("S_ADD_XCHG")),
    S_AGIT_LIST(DotenvHelper.load("S_AGIT_LIST")),
    S_AGIT_MAP(DotenvHelper.load("S_AGIT_MAP")),
    S_ARCHERARRANGE(DotenvHelper.load("S_ARCHERARRANGE")),
    S_ASK(DotenvHelper.load("S_ASK")),
    S_ATTACK(DotenvHelper.load("S_ATTACK")),
    S_ATTACK_ALL(DotenvHelper.load("S_ATTACK_ALL")),
    S_ATTACK_MANY(DotenvHelper.load("S_ATTACK_MANY")),
    S_BLIND(DotenvHelper.load("S_BLIND")),
    S_BLINK(DotenvHelper.load("S_BLINK")),
    S_BOARD_LIST(DotenvHelper.load("S_BOARD_LIST")),
    S_BOARD_READ(DotenvHelper.load("S_BOARD_READ")),
    S_BOOK_LIST(DotenvHelper.load("S_BOOK_LIST")),
    S_BREATH(DotenvHelper.load("S_BREATH")),
    S_BUY_LIST(DotenvHelper.load("S_BUY_LIST")),
    S_BUYABLE_SPELL_LIST(DotenvHelper.load("S_BUYABLE_SPELL_LIST")),
    S_CASTLE_OWNER(DotenvHelper.load("S_CASTLE_OWNER")),
    S_CHANGE_ABILITY(DotenvHelper.load("S_CHANGE_ABILITY")),
    S_CHANGE_ACCOUNTINFO_CHECK(DotenvHelper.load("S_CHANGE_ACCOUNTINFO_CHECK")),
    S_CHANGE_ALIGNMENT(DotenvHelper.load("S_CHANGE_ALIGNMENT")),
    S_CHANGE_ATTR(DotenvHelper.load("S_CHANGE_ATTR")),
    S_CHANGE_COUNT(DotenvHelper.load("S_CHANGE_COUNT")),
    S_CHANGE_DESC(DotenvHelper.load("S_CHANGE_DESC")),
    S_CHANGE_DIRECTION(DotenvHelper.load("S_CHANGE_DIRECTION")),
    S_CHANGE_ITEM_BLESS(DotenvHelper.load("S_CHANGE_ITEM_BLESS")),
    S_CHANGE_ITEM_DESC(DotenvHelper.load("S_CHANGE_ITEM_DESC")),
    S_CHANGE_ITEM_DESC_EX(DotenvHelper.load("S_CHANGE_ITEM_DESC_EX")),
    S_CHANGE_ITEM_TYPE(DotenvHelper.load("S_CHANGE_ITEM_TYPE")),
    S_CHANGE_ITEM_USE(DotenvHelper.load("S_CHANGE_ITEM_USE")),
    S_CHANGE_LEVEL(DotenvHelper.load("S_CHANGE_LEVEL")),
    S_CHANGE_LIGHT(DotenvHelper.load("S_CHANGE_LIGHT")),
    S_CHANGE_PASSWORD_CHECK(DotenvHelper.load("S_CHANGE_PASSWORD_CHECK")),
    S_CHARACTER_INFO(DotenvHelper.load("S_CHARACTER_INFO")),
    S_CLIENT_READY(DotenvHelper.load("S_CLIENT_READY")),
    S_CLONE(DotenvHelper.load("S_CLONE")),
    S_COMMAND_TARGET(DotenvHelper.load("S_COMMAND_TARGET")),
    S_CREATE_CHARACTER_CHECK(DotenvHelper.load("S_CREATE_CHARACTER_CHECK")),
    S_CRIMINAL(DotenvHelper.load("S_CRIMINAL")),
    S_DECREE(DotenvHelper.load("S_DECREE")),
    S_DELETE_CHARACTER_CHECK(DotenvHelper.load("S_DELETE_CHARACTER_CHECK")),
    S_DEPOSIT(DotenvHelper.load("S_DEPOSIT")),
    S_DRUNKEN(DotenvHelper.load("S_DRUNKEN")),
    S_EFFECT(DotenvHelper.load("S_EFFECT")),
    S_EFFECT_LOC(DotenvHelper.load("S_EFFECT_LOC")),
    S_EMBLEM(DotenvHelper.load("S_EMBLEM")),
    S_EMOTION(DotenvHelper.load("S_EMOTION")),
    S_ENTER_WORLD_CHECK(DotenvHelper.load("S_ENTER_WORLD_CHECK")),
    S_EVENT(DotenvHelper.load("S_EVENT")),
    S_EXCHANGEABLE_SPELL_LIST(DotenvHelper.load("S_EXCHANGEABLE_SPELL_LIST")),
    S_EXP(DotenvHelper.load("S_EXP")),
    S_EXTENDED(DotenvHelper.load("S_EXTENDED")),
    S_EXTENDED_HYBRID(DotenvHelper.load("S_EXTENDED_HYBRID")),
    S_EXTENDED_PROTOBUF(DotenvHelper.load("S_EXTENDED_PROTOBUF")),
    S_FIXABLE_ITEM_LIST(DotenvHelper.load("S_FIXABLE_ITEM_LIST")),
    S_HIT_POINT(DotenvHelper.load("S_HIT_POINT")),
    S_HIT_RATIO(DotenvHelper.load("S_HIT_RATIO")),
    S_HYPERTEXT(DotenvHelper.load("S_HYPERTEXT")),
    S_HYPERTEXT_INPUT(DotenvHelper.load("S_HYPERTEXT_INPUT")),
    S_IDENTIFY_CODE(DotenvHelper.load("S_IDENTIFY_CODE")),
    S_INVISIBLE(DotenvHelper.load("S_INVISIBLE")),
    S_KEY(DotenvHelper.load("S_KEY")),
    S_KICK(DotenvHelper.load("S_KICK")),
    S_LOGIN_CHECK(DotenvHelper.load("S_LOGIN_CHECK")),
    S_MAGE_DEXTERITY(DotenvHelper.load("S_MAGE_DEXTERITY")),
    S_MAGE_SHIELD(DotenvHelper.load("S_MAGE_SHIELD")),
    S_MAGE_STRENGTH(DotenvHelper.load("S_MAGE_STRENGTH")),
    S_MAGIC_STATUS(DotenvHelper.load("S_MAGIC_STATUS")),
    S_MAIL_INFO(DotenvHelper.load("S_MAIL_INFO")),
    S_MANA_POINT(DotenvHelper.load("S_MANA_POINT")),
    S_MASTER(DotenvHelper.load("S_MASTER")),
    S_MATCH_MAKING(DotenvHelper.load("S_MATCH_MAKING")),
    S_MERCENARYARRANGE(DotenvHelper.load("S_MERCENARYARRANGE")),
    S_MERCENARYEMPLOY(DotenvHelper.load("S_MERCENARYEMPLOY")),
    S_MERCENARYNAME(DotenvHelper.load("S_MERCENARYNAME")),
    S_MERCENARYSELECT(DotenvHelper.load("S_MERCENARYSELECT")),
    S_MESSAGE(DotenvHelper.load("S_MESSAGE")),
    S_MESSAGE_CODE(DotenvHelper.load("S_MESSAGE_CODE")),
    S_MOVE_OBJECT(DotenvHelper.load("S_MOVE_OBJECT")),
    S_NEW_ACCOUNT_CHECK(DotenvHelper.load("S_NEW_ACCOUNT_CHECK")),
    S_NEW_CHAR_INFO(DotenvHelper.load("S_NEW_CHAR_INFO")),
    S_NEWS(DotenvHelper.load("S_NEWS")),
    S_NOT_ENOUGH_FOR_SPELL(DotenvHelper.load("S_NOT_ENOUGH_FOR_SPELL")),
    S_NOTICE(DotenvHelper.load("S_NOTICE")),
    S_NUM_CHARACTER(DotenvHelper.load("S_NUM_CHARACTER")),
    S_PARALYSE(DotenvHelper.load("S_PARALYSE")),
    S_PERSONAL_SHOP_LIST(DotenvHelper.load("S_PERSONAL_SHOP_LIST")),
    S_PING(DotenvHelper.load("S_PING")),
    S_PLEDGE(DotenvHelper.load("S_PLEDGE")),
    S_PLEDGE_WATCH(DotenvHelper.load("S_PLEDGE_WATCH")),
    S_POISON(DotenvHelper.load("S_POISON")),
    S_POLYMORPH(DotenvHelper.load("S_POLYMORPH")),
    S_PORTAL(DotenvHelper.load("S_PORTAL")),
    S_PUT_OBJECT(DotenvHelper.load("S_PUT_OBJECT")),
    S_READ_MAIL(DotenvHelper.load("S_READ_MAIL")),
    S_REMOVE_INVENTORY(DotenvHelper.load("S_REMOVE_INVENTORY")),
    S_REMOVE_OBJECT(DotenvHelper.load("S_REMOVE_OBJECT")),
    S_REMOVE_SPELL(DotenvHelper.load("S_REMOVE_SPELL")),
    S_REQUEST_SUMMON(DotenvHelper.load("S_REQUEST_SUMMON")),
    S_RESTART(DotenvHelper.load("S_RESTART")),
    S_RESURRECT(DotenvHelper.load("S_RESURRECT")),
    S_RETRIEVE_LIST(DotenvHelper.load("S_RETRIEVE_LIST")),
    S_ROLL_RESULT(DotenvHelper.load("S_ROLL_RESULT")),
    S_SAY(DotenvHelper.load("S_SAY")),
    S_SAY_CODE(DotenvHelper.load("S_SAY_CODE")),
    S_SELECTABLE_TIME_LIST(DotenvHelper.load("S_SELECTABLE_TIME_LIST")),
    S_SELL_LIST(DotenvHelper.load("S_SELL_LIST")),
    S_SERVER_LIST(DotenvHelper.load("S_SERVER_LIST")),
    S_SHOW_MAP(DotenvHelper.load("S_SHOW_MAP")),
    S_SLAVE_CONTROL(DotenvHelper.load("S_SLAVE_CONTROL")),
    S_SOUND_EFFECT(DotenvHelper.load("S_SOUND_EFFECT")),
    S_SPEED(DotenvHelper.load("S_SPEED")),
    S_STATUS(DotenvHelper.load("S_STATUS")),
    S_TAX(DotenvHelper.load("S_TAX")),
    S_TELL(DotenvHelper.load("S_TELL")),
    S_TIME(DotenvHelper.load("S_TIME")),
    S_TITLE(DotenvHelper.load("S_TITLE")),
    S_VERSION_CHECK(DotenvHelper.load("S_VERSION_CHECK")),
    S_VOICE_CHAT(DotenvHelper.load("S_VOICE_CHAT")),
    S_WANTED_LOGIN(DotenvHelper.load("S_WANTED_LOGIN")),
    S_WAR(DotenvHelper.load("S_WAR")),
    S_WARNING_CODE(DotenvHelper.load("S_WARNING_CODE")),
    S_WEATHER(DotenvHelper.load("S_WEATHER")),
    S_WIELD(DotenvHelper.load("S_WIELD")),
    S_WITHDRAW(DotenvHelper.load("S_WITHDRAW")),
    S_WORLD(DotenvHelper.load("S_WORLD")),
    S_XCHG_RESULT(DotenvHelper.load("S_XCHG_RESULT")),
    S_XCHG_START(DotenvHelper.load("S_XCHG_START")),
    ;

    companion object {
        private val map = ServerOpcode.values().associateBy(ServerOpcode::value)
        fun fromInt(type: Int): ServerOpcode? {
            return map[type]
        }
    }

}
