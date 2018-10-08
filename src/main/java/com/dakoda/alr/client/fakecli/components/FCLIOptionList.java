package com.dakoda.alr.client.fakecli.components;

import java.util.ArrayList;

public class FCLIOptionList {

    private static final String arrowBullet = "|-> ";
    private static final String comma = ", ";
    private static final String lineEnding = "\n";
    private FCLITextBundle finalTextBundle;
    private ArrayList<FCLITextBundle> finalTextBundles;
    private final boolean isBulleted;


    public FCLIOptionList(FCLIText... texts) {
        this(false, texts);
    }

    public FCLIOptionList(boolean isBulleted, FCLIText... texts) {
        this.isBulleted = isBulleted;
        FCLIText[] t = texts;
        ArrayList<FCLIText> u = new ArrayList<>();
        if (isBulleted) {
            for (FCLIText text : t) {
                u.add(new FCLIText(arrowBullet));
                u.add(text.suffixedText(lineEnding));
            }
        } else {
            for (int i = 0; i < t.length; i++) {
                if (i > 0) u.add(new FCLIText(comma));
                u.add(t[i]);
            }
        }
        t = u.toArray(t);
        setFinalTextBundle(new FCLITextBundle(t));
    }

    public FCLIOptionList(FCLIOptionList ... commaList) {
        finalTextBundles = new ArrayList<>();
        for (FCLIOptionList list : commaList) {
            if (list.isBulleted) {
                throw new RuntimeException("You can't nest a bullet list inside of another bullet list.");
            }
        }
        this.isBulleted = true;
        for (FCLIOptionList list : commaList) {
            finalTextBundles.add(list.getFinalTextBundle().insertPrefixingText(new FCLIText(arrowBullet)));
            finalTextBundles.add(new FCLITextBundle(new FCLIText(lineEnding)));
        }
    }

    public FCLITextBundle getFinalTextBundle() {
        return finalTextBundle;
    }

    public ArrayList<FCLITextBundle> getFinalTextBundles() {
        return finalTextBundles;
    }

    private void setFinalTextBundle(FCLITextBundle finalTextBundle) {
        this.finalTextBundle = finalTextBundle;
    }
}
