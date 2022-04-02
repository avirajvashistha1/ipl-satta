package io.aviraj.ipl.iplsatta.domain;

public class PlayerBean {

    private String playerName;

    public PlayerBean(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "PlayerBean{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
