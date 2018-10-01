package com.dakoda.alr.client.fakecli.state.states.charcreate;

public enum CreationOptions {

    NAME(   "What do you want to call your character?\n" +
            "...maybe your own name..., or the name of your pet hamster..., or 'Bruce Springsteen'~\n" + optionEnding()),
    RACE(   "What race d'y'wanna be? Could be anything, if not for us already making some up.\n" +
            "Pick a race; any race.\n" +
            "|> HUMAN\n" +
            "|> FENDAN\n" + optionEnding()),
    PROFESSION( "What profession do you wanna slay with? There's a few, so take your time.\n" +
                "Pick the right one and I'll add a new item just for you.\n" +
                "|> DUELIST, PALADIN, ANTIQUER, PERFORATOR\n" +
                "|> ARCHER, ASSASSIN, NAGUAL, HUNTER\n" +
                "|> SHAMAN, PRIEST, CHRONOL, BARD\n" + optionEnding()),

    ;

    private final String string;

    CreationOptions(
            String string
    ) {
        this.string = string;
    }

    public String value() {
        return string;
    }

    static String optionEnding() {
        return "\n -> ";
    }
}