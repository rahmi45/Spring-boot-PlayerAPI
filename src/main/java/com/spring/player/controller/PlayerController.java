package com.spring.player.controller;

import java.util.List;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class PlayerController {

	private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

	// add mapping for GET/ players
    //http://localhost:8090/api/players
    @GetMapping("/players")
    public List<Player> getPlayers(){

        return playerService.allPlayer();

    }
    
    // add mapping for GET/ players
    @GetMapping("/players/{playerId}")
    public Player getPlayerId(@PathVariable int playerId){

    	Player player =  playerService.showPlayer(playerId);
    	if(player == null){
            throw new RuntimeException("Player with the following id does not exist in the database. id : " + playerId);
    	}
        return player;
    }
    
    // add mapping for POST/ players - add a new player
    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){

        // set the id of the player id to 0
        // this will force to make an insert instead of update
    	//player.setId(0);
    	playerService.savePlayer(player);
        return player;
    }
    
    // add mapping for PUT/ players - update a new player
    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player player){

        // set the id of the player id to 0
        // this will force to make an insert instead of update
    	playerService.savePlayer(player);
        return player;
    }
    
    // delete player
    @DeleteMapping("/players/{playerId}")
    public String deletePlayer(@PathVariable int playerId){

    	Player player = playerService.showPlayer(playerId);
        if(player == null){
            throw new RuntimeException("Player with the following id does not exist in the database. id : " + playerId);
        }
        playerService.deletePlayer(playerId);
        return "The deleted player is : " + playerId;
    }
}
