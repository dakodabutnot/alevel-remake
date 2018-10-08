package com.dakoda.alr.client.fakecli.components;

public class FCLIText {

    public static final String DEFAULT_COLOUR = "#ffffff";
    private static final String SUFFIX = "\n";
    private String text;
    private String colour;
    private boolean newlined;

    public FCLIText(String text) {
        this.text = text;
        this.colour = DEFAULT_COLOUR;
        this.newlined = false;
    }

    public FCLIText(String text, String colour) {
        this.text = text;
        this.colour = colour;
        this.newlined = false;
    }

    public FCLIText(String text, String colour, boolean newlined) {
        this.text = text;
        this.colour = colour;
        this.newlined = newlined;
        this.text += SUFFIX;
    }

    public FCLIText(String text, boolean newlined) {
        this.text = text;
        this.newlined = newlined;
        this.colour = DEFAULT_COLOUR;
        this.text += SUFFIX;
    }

    public String get() {
        return text;
    }

    public int getLength() {
        return text.length();
    }

    @Override
    public String toString() {
        return text;
    }

    public String getColour() {
        return colour;
    }

    public boolean isNewlined() {
        return newlined;
    }

    public FCLIText prefixedText(String prefix) {
        this.text = prefix + this.text;
        return this;
    }

    public FCLIText suffixedText(String suffix) {
        this.text = this.text + suffix;
        return this;
    }

    public FCLIText capitalized() {
        this.text = String.valueOf(this.text.charAt(0)).toUpperCase().concat(this.text.substring(1).toLowerCase());
        return this;
    }

    public FCLIText lowercased() {
        this.text = this.text.toLowerCase();
        return this;
    }

    public FCLIText uppercased() {
        this.text = this.text.toUpperCase();
        return this;
    }
}
