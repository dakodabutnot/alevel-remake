package com.dakoda.alr.game.quest;

import com.dakoda.alr.game.mechanic.Moments;
import com.dakoda.alr.game.mechanic.Moments.Moment;
import com.dakoda.alr.game.registrar.GameObject;
import com.dakoda.alr.game.world.entity.entities.npc.NPC;

import java.util.ArrayList;

public class Quest implements GameObject {

    private String description = "";
    private ArrayList<QuestRequirement> criteria = new ArrayList<>();
    private Moment requiringMoment = Moments.DEFAULT;
    private Moment achievingMoment = null;

    private Boolean canTurnIn;
    private Boolean isDone;

    private Integer experienceReward;
    private Integer currencyReward;

    private NPC givenBy;

    public void turnIn() {
        finish();
    }

    public Quest withRequirement(QuestRequirement requirement) {
        criteria.add(requirement);
        return this;
    }

    public Quest withDescription(String desc) {
        this.description = desc;
        return this;
    }

    public Quest requiresMoment(Moment moment) {
        this.requiringMoment = moment;
        return this;
    }

    public Quest completesMoment(Moment moment) {
        this.achievingMoment = moment;
        return this;
    }

    public Quest givenByNPC(NPC npc) {
        this.givenBy = npc;
        return this;
    }

    public Quest withExperienceReward(Integer exp) {
        this.experienceReward = exp;
        return this;
    }

    public Quest withCurrencyReward(Integer currency) {
        this.currencyReward = currency;
        return this;
    }

    public ArrayList<QuestRequirement> criteria() {
        return criteria;
    }

    public String getDescription() {
        return description;
    }

    public NPC getNPCWhoGives() {
        return givenBy;
    }

    public Moment getRequiringMoment() {
        return requiringMoment;
    }

    public Moment getAchievingMoment() {
        return achievingMoment;
    }

    public Integer getExperienceReward() {
        return experienceReward;
    }

    public Integer getCurrencyReward() {
        return currencyReward;
    }

    public void finish() {
        this.isDone = Boolean.TRUE;
        this.achievingMoment.complete();
    }

    public Boolean isFinished() {
        return isDone;
    }

    public Boolean canTurnIn() {
        return canTurnIn;
    }

    public void validateFinishability() {
        Boolean canFinish = Boolean.TRUE;
        for (QuestRequirement criterion : criteria) {
            if (!criterion.checkFinished()) {
                canFinish = Boolean.FALSE;
                break;
            }
        }
        if (canFinish) canTurnIn = Boolean.TRUE;
    }
}