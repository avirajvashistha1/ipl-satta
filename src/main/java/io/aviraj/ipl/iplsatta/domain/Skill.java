package io.aviraj.ipl.iplsatta.domain;

public enum Skill {

    BATSMAN(1),
    BOWLER(2),
    WICKETKEEPER(3),
    ALLROUNDER(4);

    private int skillValue;

    private Skill(int skillValue){
        this.skillValue = skillValue;
    }

}
