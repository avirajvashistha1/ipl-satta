package io.aviraj.ipl.iplsatta.domain;

import javax.validation.constraints.Size;
import java.util.List;

public class Player {



    private Integer playerId;

    @Size(min = 2, message = "Player Name should be at least 2 characters")
    private String playerName;
    private String team;
    private List<String> pastTeams;

    private Skill primarySkill;

    public Player(Integer playerId, String playerName, String team, List<String> pastTeams, Skill primarySkill) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.team = team;
        this.pastTeams = pastTeams;
        this.primarySkill = primarySkill;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Player setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public String getTeam() {
        return team;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public Player setPlayerId(Integer playerId) {
        this.playerId = playerId;
        return this;
    }

    public Player setTeam(String team) {
        this.team = team;
        return this;
    }

    public List<String> getPastTeams() {
        return pastTeams;
    }

    public Player setPastTeams(List<String> pastTeams) {
        this.pastTeams = pastTeams;
        return this;
    }

    public Skill getPrimarySkill() {
        return primarySkill;
    }

    public Player setPrimarySkill(Skill primarySkill) {
        this.primarySkill = primarySkill;
        return this;
    }
}
