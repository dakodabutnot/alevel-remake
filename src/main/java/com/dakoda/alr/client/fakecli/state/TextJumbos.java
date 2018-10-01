package com.dakoda.alr.client.fakecli.state;

public enum TextJumbos {

    SPLASH( "█▀▄▀█ ▄███▄      ▄     ▄   \n" +
            "█ █ █ █▀   ▀      █     █  \n" +
            "█ ▄ █ ██▄▄    ██   █ █   █ \n" +
            "█   █ █▄   ▄▀ █ █  █ █   █ \n" +
            "   █  ▀███▀   █  █ █ █▄ ▄█ \n" +
            "  ▀           █   ██  ▀▀▀  \n" +
            "                           \n"),
    CREATE_NAME("   ▄   ██   █▀▄▀█ ▄███▄   \n" +
                "    █  █ █  █ █ █ █▀   ▀  \n" +
                "██   █ █▄▄█ █ ▄ █ ██▄▄    \n" +
                "█ █  █ █  █ █   █ █▄   ▄▀ \n" +
                "█  █ █    █    █  ▀███▀   \n" +
                "█   ██   █    ▀           \n" +
                "        ▀                 \n"),
    CREATE_RACE("█▄▄▄▄ ██   ▄█▄    ▄███▄   \n" +
                "█  ▄▀ █ █  █▀ ▀▄  █▀   ▀  \n" +
                "█▀▀▌  █▄▄█ █   ▀  ██▄▄    \n" +
                "█  █  █  █ █▄  ▄▀ █▄   ▄▀ \n" +
                "  █      █ ▀███▀  ▀███▀   \n" +
                " ▀      █                 \n" +
                "       ▀                  \n"),
    CREATE_PROFESSION(  "█ ▄▄  █▄▄▄▄ ████▄ ▄████  ▄███▄     ▄▄▄▄▄    ▄▄▄▄▄   ▄█ ████▄    ▄   \n" +
                        "█   █ █  ▄▀ █   █ █▀   ▀ █▀   ▀   █     ▀▄ █     ▀▄ ██ █   █     █  \n" +
                        "█▀▀▀  █▀▀▌  █   █ █▀▀    ██▄▄   ▄  ▀▀▀▀▄ ▄  ▀▀▀▀▄   ██ █   █ ██   █ \n" +
                        "█     █  █  ▀████ █      █▄   ▄▀ ▀▄▄▄▄▀   ▀▄▄▄▄▀    ▐█ ▀████ █ █  █ \n" +
                        " █      █          █     ▀███▀                       ▐       █  █ █ \n" +
                        "  ▀    ▀            ▀                                        █   ██ \n" +
                        "                                                                    \n"),

    ;

    private final String string;

    TextJumbos(
            String string
    ) {
        this.string = string;
    }

    public String value() {
        return string;
    }
}
