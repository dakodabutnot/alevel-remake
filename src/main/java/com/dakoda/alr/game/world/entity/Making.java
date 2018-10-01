package com.dakoda.alr.game.world.entity;

import java.awt.*;

public class Making {

    private Gender gender;
    private Sexuality sexuality;
    private SkinColour skinColour;
    private boolean skinAsFur = false;
    private FurColour furColour;
    private HairColour hairColour;
    private EyeColour eyeColour;
    private Race race;

    public Making withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Making withSexuality(Sexuality sexuality) {
        this.sexuality = sexuality;
        return this;
    }

    public Making withRace(Race race) {
        this.race = race;
        return this;
    }

    public Making withSkinAsFur() {
        this.skinAsFur = true;
        return this;
    }

    public Making withSkinColour(SkinColour skinColour) {
        this.skinColour = skinColour;
        return this;
    }

    public Making withFurColour(FurColour furColour) {
        this.furColour = furColour;
        return this;
    }

    public Making withHairColour(HairColour hairColour) {
        this.hairColour = hairColour;
        return this;
    }

    public Making withEyeColour(EyeColour eyeColour) {
        this.eyeColour = eyeColour;
        return this;
    }

    public enum Gender {
        MALE, FEMALE, TRANSMALE, TRANSFEMALE, AGENDER;
    }

    public enum Sexuality {
        STRAIGHT, GAY, BISEXUAL, ASEXUAL;
    }

    public enum EyeColour {

        BLUE(94, 144, 224),
        GREEN(80, 178, 90),
        BROWN(96, 63, 48),
        RED(209, 58, 58),
        ;

        private final Color colour;

        EyeColour(
                int red,
                int green,
                int blue
        ) {
            this.colour = new Color(red, green, blue);
        }

        public Color colour() {
            return colour;
        }
    }

    public enum HairColour {

        BROWN(76, 51, 45),
        BLONDE(226, 220, 158),
        BLACK(43, 42, 41),
        GINGER(160, 53, 24),
        ;

        private final Color colour;

        HairColour(
                int red,
                int green,
                int blue
        ) {
            this.colour = new Color(red, green, blue);
        }

        public Color colour() {
            return colour;
        }
    }

    public enum SkinColour {

        WHITE(237, 223, 201),
        MIXED(216, 179, 121),
        BLACK(71, 57, 45),
        ;

        private final Color colour;

        SkinColour(
                int red,
                int green,
                int blue
        ) {
            this.colour = new Color(red, green, blue);
        }

        public Color colour() {
            return colour;
        }
    }

    public enum FurColour {

        WHITE(237, 223, 201),
        BROWN(76, 51, 45),
        BLONDE(226, 220, 158),
        BLACK(43, 42, 41),
        GINGER(160, 53, 24),
        BLUE(94, 144, 224),
        GREEN(80, 178, 90),
        RED(209, 58, 58),
        ;

        private final Color colour;

        FurColour(
                int red,
                int green,
                int blue
        ) {
            this.colour = new Color(red, green, blue);
        }

        public Color colour() {
            return colour;
        }
    }

    public enum Race {
        HUMAN, FENDAN;
    }

    public boolean isSkinAsFur() {
        return skinAsFur;
    }

    public Gender getGender() {
        return gender;
    }

    public Sexuality getSexuality() {
        return sexuality;
    }

    public EyeColour getEyeColour() {
        return eyeColour;
    }

    public HairColour getHairColour() {
        return hairColour;
    }

    public FurColour getFurColour() {
        return furColour;
    }

    public SkinColour getSkinColour() {
        return skinColour;
    }

    public Race getRace() {
        return race;
    }
}