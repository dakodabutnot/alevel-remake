package com.dakoda.alr;

import com.dakoda.alr.game.GameMaster;

import static com.dakoda.alr.game.GameMaster.Content.*;

public class TextRPG {

    public static GameMaster master = new GameMaster();

    public static void main(String[] args) {

        System.out.println(master.registrar(ITEM).findContentByName("Ambrosia"));
    }
}