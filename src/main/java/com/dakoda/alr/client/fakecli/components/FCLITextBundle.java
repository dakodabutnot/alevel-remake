package com.dakoda.alr.client.fakecli.components;

import java.util.ArrayList;
import java.util.Arrays;

public class FCLITextBundle {

    private ArrayList<FCLIText> texts = new ArrayList<>();

    public FCLITextBundle(FCLIText ... texts) {
        this.texts.addAll(Arrays.asList(texts));
    }

    public ArrayList<FCLIText> getTexts() {
        return texts;
    }

    @Override
    public String toString() {
        StringBuilder full = new StringBuilder();
        texts.forEach(fcliText -> full.append(fcliText.toString()));
        return full.toString();
    }

    public FCLITextBundle insertPrefixingText(FCLIText text) {
        texts.add(0, text);
        return this;
    }
}
