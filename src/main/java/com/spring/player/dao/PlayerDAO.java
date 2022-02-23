package com.spring.player.dao;

import com.spring.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerDAO extends JpaRepository<Player, Integer > {

  /*  List<Player> getPlayers();

    void addPlayer(Player player);

    Player getPlayer(int id);

    void removePlayer(int id);*/


}
