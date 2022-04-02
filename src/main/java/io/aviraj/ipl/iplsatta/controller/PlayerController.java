package io.aviraj.ipl.iplsatta.controller;

import io.aviraj.ipl.iplsatta.Exceptions.PlayerNotFoundException;
import io.aviraj.ipl.iplsatta.domain.Player;
import io.aviraj.ipl.iplsatta.domain.PlayerBean;
import io.aviraj.ipl.iplsatta.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.ControllerEntityLinksFactoryBean;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/greetplayer")
    public String ackPlayer(){
        return "Hello Player !!";
    }

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/player-bean/{name}")
    public PlayerBean getPlayerBean(@PathVariable String name){
        return new PlayerBean(name);
    }

    @GetMapping("/findplayer/{name}")
    public List<Player> getPlayerByName(@PathVariable String name){
        List<Player> playerbyName = playerService.getPlayerbyName(name);

        if(playerbyName == null || playerbyName.isEmpty()){
            throw new PlayerNotFoundException("Player Name : "+name);
        }

        return playerbyName;
    }

    @GetMapping("/player/{id}")
    public EntityModel<Player> getPlayerById(@PathVariable Integer id){
        List<Player> playersbyId = playerService.getPlayerbyId(id);

        if(playersbyId == null || playersbyId.isEmpty()){
            throw new PlayerNotFoundException("ID - "+id);
        }

        EntityModel<Player> resource = new EntityModel<Player>(playersbyId.get(0));
        
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPlayers());
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPlayerById(playersbyId.get(0).getPlayerId()));

        resource.add(link.withRel("all-players"));		
        resource.add(link2.withRel("Get-Player-By-ID"));
        
        return resource;
    }

    @PostMapping("/player")
    public ResponseEntity savePlayer(@Valid @RequestBody Player player){
        Player savedPlayer = playerService.savePlayer(player);

        URI uri = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port("8080").path("/player/{id}").buildAndExpand(savedPlayer.getPlayerId()).toUri();
        System.out.println(uri.toString());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayerById(@PathVariable Integer id){
        Player removedPlayer = playerService.deletePlayer(id);
        if(removedPlayer == null){
            throw new PlayerNotFoundException("ID -"+id);
        }
    }


}
