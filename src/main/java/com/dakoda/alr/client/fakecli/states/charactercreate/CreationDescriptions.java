package com.dakoda.alr.client.fakecli.states.charactercreate;

public enum CreationDescriptions {

    NAME(   "What do you want to call your character?\n" +
            "...maybe your own name..., or the name of your pet hamster..., or 'Bruce Springsteen'~\n" + optionEnding()),
    RACE(   "What race d'y'wanna be? Could be anything, if not for us already making some up.\n" +
            "Pick a race; any race.\n" + optionEnding()),
    PROFESSION( "What profession do you wanna slay with? There's a few, so take your time.\n" +
                "Pick the right one and I'll add a new item just for you.\n" + optionEnding()),

    ;

    private final String string;

    CreationDescriptions(
            String string
    ) {
        this.string = string;
    }

    public String value() {
        return string;
    }

    static String optionEnding() {
        return "";
    }
}