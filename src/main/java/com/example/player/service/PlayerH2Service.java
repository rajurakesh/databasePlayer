
// You can use the following import statements
package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.player.model.PlayerRowMapper;
import com.example.player.model.Player;

import com.example.player.repository.PlayerRepository;
import java.util.*;

@Service
public class PlayerH2Service implements PlayerRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Player> getPlayers() {

        List<Player> playerList = db.query("select * from TEAM", new PlayerRowMapper());
        ArrayList<Player> players = new ArrayList<>(playerList);
        return players;
    }

    @Override
    public Player getPlayerById(int playerId) {
        Player player = db.queryForObject("SELECT * FROM TEAM WHERE playerId = ?", new PlayerRowMapper(), playerId);
        return player;
    }

    /*
     * @Override
     * public Player addPlayer(Player player) {
     * db.update("insert into TEAM(playerId,playerName,jersyNumber,role") values(?,
     * ?, ?, ?), player.getPlayerId(),
     * player.getPlayerName(),player.getJersyNumber(),player.getRole());
     * Player players = db.
     * queryForObject("select * from TEAM where playerId = ? and playerName = ? and jersyNumber = ? and role = ?"
     * ,
     * new PlayerRowMapper(),
     * player.getPlayerId(),player.getPlayerName(),player.getJersyNumber(),player.
     * getRole());
     * 
     * }
     */

}

// Write your code here