package io.aviraj.ipl.iplsatta.DAO;

import io.aviraj.ipl.iplsatta.domain.Player;
import io.aviraj.ipl.iplsatta.domain.Skill;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class PlayerDAO {

    private static List<Player> players = new ArrayList<>();

    private static int playerCount = 2;

    static {
        players.add(new Player(1,"Sachin Tendulkar", "Mumbai Indians", null, Skill.BATSMAN));
        players.add(new Player(2,"Rohit Sharma", "Mumbai Indians", null, Skill.BATSMAN));
    }

    public List<Player> getAllPlayers(){
        return players;
    }

    public List<Player> getPlayerByName(String name) {
        List<Player> playerList = new ArrayList<>();
        for(Player player : players){
            if(player.getPlayerName().toLowerCase().contains(name.toLowerCase())){
                playerList.add(player);
            }
        }
        return playerList;
    }

    public Player save(Player player){
        if(player.getPlayerId() == null){
            player.setPlayerId(++playerCount);
        }
        players.add(player);
        return player;
    }

    public List<Player> getPlayerById(Integer id) {
        List<Player> playerList = new ArrayList<>();
        for(Player player : players){
            if(player.getPlayerId().equals(id)){
                playerList.add(player);
            }
        }
        return playerList;
    }

    public Player deleteById(Integer id){
        Iterator<Player> plyrs = players.iterator();
        while(plyrs.hasNext()){
            Player player = plyrs.next();
            if(player.getPlayerId()==id){
                plyrs.remove();
                return player;
            }
        }
        return null;
    }
}
