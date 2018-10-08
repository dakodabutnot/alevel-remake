package com.dakoda.alr.client.fakecli.states;

import com.dakoda.alr.client.fakecli.components.FCLITextBundle;
import com.dakoda.alr.client.fakecli.components.FCLIText;

public enum TextJumbos {

    /**
     * ANSI Shadow
     * http://patorjk.com/software/taag/
     */

    SPLASH(
            new FCLITextBundle(
                    new FCLIText("███╗   ███╗███████╗███╗   ██╗██╗   ██╗", true),
                    new FCLIText("████╗ ████║██╔════╝████╗  ██║██║   ██║", true),
                    new FCLIText("██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║", true),
                    new FCLIText("██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║", true),
                    new FCLIText("██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝", true),
                    new FCLIText("╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ ", true)
            )
    ),
    CREATE_NAME(
            new FCLITextBundle(
                    new FCLIText("███╗   ██╗ █████╗ ███╗   ███╗███████╗", true),
                    new FCLIText("████╗  ██║██╔══██╗████╗ ████║██╔════╝", true),
                    new FCLIText("██╔██╗ ██║███████║██╔████╔██║█████╗  ", true),
                    new FCLIText("██║╚██╗██║██╔══██║██║╚██╔╝██║██╔══╝  ", true),
                    new FCLIText("██║ ╚████║██║  ██║██║ ╚═╝ ██║███████╗", true),
                    new FCLIText("╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝", true)
            )
    ),

    CREATE_RACE(
            new FCLITextBundle(
                    new FCLIText("██████╗  █████╗  ██████╗███████╗", true),
                    new FCLIText("██╔══██╗██╔══██╗██╔════╝██╔════╝", true),
                    new FCLIText("██████╔╝███████║██║     █████╗  ", true),
                    new FCLIText("██╔══██╗██╔══██║██║     ██╔══╝  ", true),
                    new FCLIText("██║  ██║██║  ██║╚██████╗███████╗", true),
                    new FCLIText("╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚══════╝", true)
            )
    ),
    CREATE_PROFESSION(
            new FCLITextBundle(
                    new FCLIText("██████╗ ██████╗  ██████╗ ███████╗███████╗███████╗███████╗██╗ ██████╗ ███╗   ██╗", true),
                    new FCLIText("██╔══██╗██╔══██╗██╔═══██╗██╔════╝██╔════╝██╔════╝██╔════╝██║██╔═══██╗████╗  ██║", true),
                    new FCLIText("██████╔╝██████╔╝██║   ██║█████╗  █████╗  ███████╗███████╗██║██║   ██║██╔██╗ ██║", true),
                    new FCLIText("██╔═══╝ ██╔══██╗██║   ██║██╔══╝  ██╔══╝  ╚════██║╚════██║██║██║   ██║██║╚██╗██║", true),
                    new FCLIText("██║     ██║  ██║╚██████╔╝██║     ███████╗███████║███████║██║╚██████╔╝██║ ╚████║", true),
                    new FCLIText("╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚══════╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝", true)
            )
    ),

    ;

    private final FCLITextBundle fcliTextBundle;

    TextJumbos(
            FCLITextBundle fcliTextBundle
    ) {
        this.fcliTextBundle = fcliTextBundle;
    }

    public FCLITextBundle value() {
        return fcliTextBundle;
    }
}
