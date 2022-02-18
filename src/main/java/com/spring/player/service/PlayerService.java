package com.spring.player.service;

import com.spring.player.model.Player;

import java.util.List;

public interface PlayerService {

	public List<Player> allPlayer();
	
	public void savePlayer(Player player);
	
	public Player showPlayer(int id);
	
	public void deletePlayer(int id);
		
}
