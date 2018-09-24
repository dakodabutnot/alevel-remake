package com.dakoda.alr;

import com.dakoda.alr.client.cli.CLIMain;
import com.dakoda.alr.content.ContentMaster;
import com.dakoda.alr.game.GameMaster;
import com.dakoda.alr.game.mechanic.Currency;

public class TextRPG {

    public static GameMaster master = new GameMaster();
    public static ContentMaster content = new ContentMaster();

    public static void main(String[] args) {
        CLIMain.run();

        System.out.println(Currency.convertToUnits(612873123));
    }
}