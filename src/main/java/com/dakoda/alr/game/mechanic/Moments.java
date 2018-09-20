package com.dakoda.alr.game.mechanic;

public class Moments {

    public static Moment DEFAULT = new Moment(true);
    public static Moment PLAYER_LEVEL_5 = new Moment();
    public static Moment COMPLETED_ZOMBIE_QUEST = new Moment();

    public static class Moment {
        private Boolean complete;

        private Moment() {
            this.complete = Boolean.FALSE;
        }

        private Moment(Boolean complete) {
            this.complete = complete;
        }

        public Boolean isComplete() {
            return complete;
        }

        public void complete() {
            this.complete = true;
        }
    }
}
