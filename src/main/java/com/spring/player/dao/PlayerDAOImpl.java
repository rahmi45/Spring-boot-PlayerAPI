package com.spring.player.dao;

import com.spring.player.model.Player;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PlayerDAOImpl implements PlayerDAO {


    private EntityManager entityManager;

    public PlayerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Player> getPlayers() {
        Session session = entityManager.unwrap(Session.class);

        Query<Player> query = session.createQuery("from Player", Player.class);

        return query.getResultList();
    }

    @Override
    public void addPlayer(Player player) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(player);

    }

    @Override
    public Player getPlayer(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Player.class, id);
    }

    @Override
    public void removePlayer(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Player where id=?1");
        query.setInteger(1, id);
        query.executeUpdate();

    }

}