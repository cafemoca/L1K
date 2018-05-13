package cm.moca.l1k.server.packets.client

enum class ClientOpcode(val value: Int) {

    C_ACCEPT_XCHG(0),
    C_ACTION(0),
    C_ADD_BUDDY(0),
    C_ADD_XCHG(0),
    C_ADDR(0),
    C_ALIVE(0),
    C_ALT_ATTACK(0),
    C_ANSWER(0),
    C_ARCHERARRANGE(0),
    C_ASK_XCHG(0),
    C_ATTACK(0),
    C_ATTACK_CONTINUE(0),
    C_BAN(0),
    C_BAN_MEMBER(0),
    C_BANISH_PARTY(0),
    C_BLINK(0),
    C_BOARD_DELETE(0),
    C_BOARD_LIST(0),
    C_BOARD_READ(0),
    C_BOARD_WRITE(0),
    C_BOOK(0),
    C_BOOKMARK(0),
    C_BUILDER_CONTROL(0),
    C_BUY_SELL(0),
    C_BUY_SPELL(0),
    C_BUYABLE_SPELL(0),
    C_CANCEL_XCHG(0),
    C_CHANGE_ACCOUNTINFO(0),
    C_CHANGE_CASTLE_SECURITY(0),
    C_CHANGE_DIRECTION(0),
    C_CHANGE_PASSWORD(0),
    C_CHANNEL(0),
    C_CHAT(0),
    C_CHAT_PARTY_CONTROL(0),
    C_CHECK_INVENTORY(0),
    C_CHECK_PK(0),
    C_CLIENT_READY(0),
    C_CONTROL_WEATHER(0),
    C_CREATE_CUSTOM_CHARACTER(0),
    C_CREATE_PLEDGE(0),
    C_DEAD_RESTART(0),
    C_DELETE_BOOKMARK(0),
    C_DELETE_CHARACTER(0),
    C_DEPOSIT(0),
    C_DESTROY_ITEM(0),
    C_DIALOG(0),
    C_DROP(0),
    C_DUEL(0),
    C_EMBLEM(0),
    C_ENTER_PORTAL(0),
    C_ENTER_SHIP(0),
    C_ENTER_WORLD(0),
    C_EXCHANGE_SPELL(0),
    C_EXCHANGEABLE_SPELL(0),
    C_EXCLUDE(0),
    C_EXIT_GHOST(0),
    C_EXTENDED(0),
    C_EXTENDED_HYBRID(0),
    C_EXTENDED_PROTOBUF(0),
    C_FAR_ATTACK(0),
    C_FIX(0),
    C_FIXABLE_ITEM(0),
    C_GET(0),
    C_GIVE(0),
    C_GOTO_MAP(0),
    C_GOTO_PORTAL(0),
    C_HACTION(0),
    C_HYPERTEXT_INPUT_RESULT(0),
    C_INCLUDE(0),
    C_INVITE_PARTY(0),
    C_INVITE_PARTY_TARGET(0),
    C_JOIN_PLEDGE(0),
    C_KICK(0),
    C_LEAVE_PARTY(0),
    C_LEAVE_PLEDGE(0),
    C_LOGIN(0),
    C_LOGIN_RESULT(0),
    C_LOGIN_TEST(0),
    C_LOGOUT(0),
    C_MAIL(0),
    C_MARRIAGE(0),
    C_MATCH_MAKING(0),
    C_MERCENARYARRANGE(0),
    C_MERCENARYEMPLOY(0),
    C_MERCENARYNAME(0),
    C_MERCENARYSELECT(0),
    C_MONITOR_CONTROL(0),
    C_MOVE(0),
    C_NEW_ACCOUNT(0),
    C_NPC_ITEM_CONTROL(0),
    C_ONOFF(0),
    C_OPEN(0),
    C_PERSONAL_SHOP(0),
    C_PLATE(0),
    C_PLEDGE_WATCH(0),
    C_QUERY_BUDDY(0),
    C_QUERY_CASTLE_SECURITY(0),
    C_QUERY_PERSONAL_SHOP(0),
    C_QUIT(0),
    C_RANK_CONTROL(0),
    C_READ_NEWS(0),
    C_READ_NOTICE(0),
    C_REGISTER_QUIZ(0),
    C_REMOVE_BUDDY(0),
    C_REQUEST_ROLL(0),
    C_RESTART(0),
    C_RETURN_SUMMON(0),
    C_SAVE(0),
    C_SAVEIO(0),
    C_SAY(0),
    C_SELECT_TIME(0),
    C_SELECTABLE_TIME(0),
    C_SERVER_SELECT(0),
    C_SHIFT_SERVER(0),
    C_SHUTDOWN(0),
    C_SILENCE(0),
    C_SLAVE_CONTROL(0),
    C_SMS(0),
    C_START_CASTING(0),
    C_SUMMON(0),
    C_TAX(0),
    C_TELEPORT(0),
    C_TELEPORT_USER(0),
    C_TELL(0),
    C_THROW(0),
    C_TITLE(0),
    C_UPLOAD_EMBLEM(0),
    C_USE_ITEM(0),
    C_USE_SPELL(0),
    C_VERSION(0),
    C_VOICE_CHAT(0),
    C_WANTED(0),
    C_WAR(0),
    C_WAREHOUSE_CONTROL(0),
    C_WHO(0),
    C_WHO_PARTY(0),
    C_WHO_PLEDGE(0),
    C_WISH(0),
    C_WITHDRAW(0),
    ;

    companion object {
        private val map = ClientOpcode.values().associateBy(ClientOpcode::value)
        fun fromInt(type: Int): ClientOpcode? = map[type]
    }

}