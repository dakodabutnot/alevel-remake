package com.dakoda.alr;

import java.util.Random;

public enum SuccessLenny {

    ONE("ヽ(ᚖᗜᚖ)ﾉ"),
    TWO("ᕦ@ヘ@ᕥ"),
    THREE("\\(■ᗜ■)/"),
    FOUR("ᑴ ͡⎚Ꮂ ͡⎚ᑷ"),
    FIVE("ᕙ(´• ᗜ •`)ᕗ"),
    SIX("(╭☞⪧◡⪦)╭☞"),
    SEVEN("\\(⚆ω⚆)/"),
    EIGHT("⤜(の◡の)⤏"),
    NINE("ᘳಠ ͜ʖಠᘰ"),
    TEN("\\( ﾟ ͜つ ﾟ)/"),

    ;

    private final String value;

    SuccessLenny(
            String value
    ) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static String random() {
        return SuccessLenny.values()[new Random().nextInt(SuccessLenny.values().length)].value();
    }
}
