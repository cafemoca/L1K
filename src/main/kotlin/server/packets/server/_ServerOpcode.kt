package cm.moca.l1k.server.packets

enum class _ServerOpcode(val value: Int) {

    S_ABILITY_SCORES(0),
    S_AC(0),
    S_ACTION(0),
    S_ADD_BOOKMARK(0),
    S_ADD_INVENTORY(0),
    S_ADD_INVENTORY_BATCH(0),
    S_ADD_SPELL(0),
    S_ADD_XCHG(0),
    S_AGIT_LIST(0),
    S_AGIT_MAP(0),
    S_ARCHERARRANGE(0),
    S_ASK(0),
    S_ATTACK(0),
    S_ATTACK_ALL(0),
    S_ATTACK_MANY(0),
    S_BLIND(0),
    S_BLINK(0),
    S_BOARD_LIST(0),
    S_BOARD_READ(0),
    S_BOOK_LIST(0),
    S_BREATH(0),
    S_BUY_LIST(0),
    S_BUYABLE_SPELL_LIST(0),
    S_CASTLE_OWNER(0),
    S_CHANGE_ABILITY(0),
    S_CHANGE_ACCOUNTINFO_CHECK(0),
    S_CHANGE_ALIGNMENT(0),
    S_CHANGE_ATTR(0),
    S_CHANGE_COUNT(0),
    S_CHANGE_DESC(0),
    S_CHANGE_DIRECTION(0),
    S_CHANGE_ITEM_BLESS(0),
    S_CHANGE_ITEM_DESC(0),
    S_CHANGE_ITEM_DESC_EX(0),
    S_CHANGE_ITEM_TYPE(0),
    S_CHANGE_ITEM_USE(0),
    S_CHANGE_LEVEL(0),
    S_CHANGE_LIGHT(0),
    S_CHANGE_PASSWORD_CHECK(0),
    S_CHARACTER_INFO(0),
    S_CLIENT_READY(0),
    S_CLONE(0),
    S_COMMAND_TARGET(0),
    S_CREATE_CHARACTER_CHECK(0),
    S_CRIMINAL(0),
    S_DECREE(0),
    S_DELETE_CHARACTER_CHECK(0),
    S_DEPOSIT(0),
    S_DRUNKEN(0),
    S_EFFECT(0),
    S_EFFECT_LOC(0),
    S_EMBLEM(0),
    S_EMOTION(0),
    S_ENTER_WORLD_CHECK(0),
    S_EVENT(0),
    S_EXCHANGEABLE_SPELL_LIST(0),
    S_EXP(0),
    S_EXTENDED(0),
    S_EXTENDED_HYBRID(0),
    S_EXTENDED_PROTOBUF(0),
    S_FIXABLE_ITEM_LIST(0),
    S_HIT_POINT(0),
    S_HIT_RATIO(0),
    S_HYPERTEXT(0),
    S_HYPERTEXT_INPUT(0),
    S_IDENTIFY_CODE(0),
    S_INVISIBLE(0),
    S_KEY(0),
    S_KICK(0),
    S_LOGIN_CHECK(0),
    S_MAGE_DEXTERITY(0),
    S_MAGE_SHIELD(0),
    S_MAGE_STRENGTH(0),
    S_MAGIC_STATUS(0),
    S_MAIL_INFO(0),
    S_MANA_POINT(0),
    S_MASTER(0),
    S_MATCH_MAKING(0),
    S_MERCENARYARRANGE(0),
    S_MERCENARYEMPLOY(0),
    S_MERCENARYNAME(0),
    S_MERCENARYSELECT(0),
    S_MESSAGE(0),
    S_MESSAGE_CODE(0),
    S_MOVE_OBJECT(0),
    S_NEW_ACCOUNT_CHECK(0),
    S_NEW_CHAR_INFO(0),
    S_NEWS(0),
    S_NOT_ENOUGH_FOR_SPELL(0),
    S_NOTICE(0),
    S_NUM_CHARACTER(0),
    S_PARALYSE(0),
    S_PERSONAL_SHOP_LIST(0),
    S_PING(0),
    S_PLEDGE(0),
    S_PLEDGE_WATCH(0),
    S_POISON(0),
    S_POLYMORPH(0),
    S_PORTAL(0),
    S_PUT_OBJECT(0),
    S_READ_MAIL(0),
    S_REMOVE_INVENTORY(0),
    S_REMOVE_OBJECT(0),
    S_REMOVE_SPELL(0),
    S_REQUEST_SUMMON(0),
    S_RESTART(0),
    S_RESURRECT(0),
    S_RETRIEVE_LIST(0),
    S_ROLL_RESULT(0),
    S_SAY(0),
    S_SAY_CODE(0),
    S_SELECTABLE_TIME_LIST(0),
    S_SELL_LIST(0),
    S_SERVER_LIST(0),
    S_SHOW_MAP(0),
    S_SLAVE_CONTROL(0),
    S_SOUND_EFFECT(0),
    S_SPEED(0),
    S_STATUS(0),
    S_TAX(0),
    S_TELL(0),
    S_TIME(0),
    S_TITLE(0),
    S_VERSION_CHECK(0),
    S_VOICE_CHAT(0),
    S_WANTED_LOGIN(0),
    S_WAR(0),
    S_WARNING_CODE(0),
    S_WEATHER(0),
    S_WIELD(0),
    S_WITHDRAW(0),
    S_WORLD(0),
    S_XCHG_RESULT(0),
    S_XCHG_START(0),
    ;

    companion object {
        private val map = _ServerOpcode.values().associateBy(_ServerOpcode::value)
        fun fromInt(type: Int): _ServerOpcode? {
            return map[type]
        }
    }

}
