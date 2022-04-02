package io.aviraj.ipl.iplsatta.services;

import io.aviraj.ipl.iplsatta.DAO.PlayerDAO;
import io.aviraj.ipl.iplsatta.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    public List<Player> getAllPlayers(){
        return playerDAO.getAllPlayers();
    }

    public List<Player> getPlayerbyName(String name) {
        return playerDAO.getPlayerByName(name);
    }

    public Player savePlayer(Player player){
        return playerDAO.save(player);
    }

    public List<Player> getPlayerbyId(Integer id) {
        return playerDAO.getPlayerById(id);
    }

    public Player deletePlayer(Integer id){
        return playerDAO.deleteById(id);
    }
}
