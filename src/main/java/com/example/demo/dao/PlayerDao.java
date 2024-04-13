package com.example.demo.dao;

import com.example.demo.entity.Player;
import com.example.demo.entity.Profession;
import com.example.demo.entity.Race;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
1. получать список всех зарегистрированных игроков;
2. создавать нового игрока;
3. редактировать характеристики существующего игрока;
4. удалять игрока;
5. получать игрока по id;
6. получать отфильтрованный список игроков в соответствии с переданными фильтрами;
7. получать количество игроков, которые соответствуют фильтрам.
   Для этого необходимо реализовать REST API в соответствии с документацией.
 */

@Repository
@RequiredArgsConstructor
public class PlayerDao {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Player> playerRowMapper = (rs, rowNum) -> {
        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setName(rs.getString("name"));
        player.setTitle(rs.getString("title"));
        player.setRace(Race.valueOf(rs.getString("race")));
        player.setProfession(Profession.valueOf(rs.getString("profession")));
        player.setExperience(rs.getInt("experience"));
        player.setLevel(rs.getInt("level"));
        player.setUntilNextLevel(rs.getInt("until_next_level"));
        player.setBirthday(rs.getDate("birthday"));
        player.setBanned(rs.getBoolean("banned"));
        return player;
    };

    public List<Player> getAllPlayers() {
        return jdbcTemplate.query("SELECT id, name, title, race, profession, experience, level, until_next_level, birthday, banned FROM players",
                playerRowMapper);
    }

    public void addNewPlayer(Player player) {
        String sql = "INSERT INTO players (name, title, race, profession, experience, level, until_next_level, birthday, banned) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                player.getName(),
                player.getTitle(),
                player.getRace().name(),
                player.getProfession().name(),
                player.getExperience(),
                player.getLevel(),
                player.getUntilNextLevel(),
                player.getBirthday(),
                player.getBanned());
    }
    public void updatePlayer(Player player) {
        String sql = "UPDATE players SET name = ?, title = ?, race = ?, profession = ?, experience = ?, level = ?, until_next_level = ?, birthday = ?, banned = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                player.getName(),
                player.getTitle(),
                player.getRace().name(),
                player.getProfession().name(),
                player.getExperience(),
                player.getLevel(),
                player.getUntilNextLevel(),
                player.getBirthday(),
                player.getBanned(),
                player.getId());
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT id, name, title, race, profession, experience, level, until_next_level, birthday, banned FROM players WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, playerRowMapper, id);
    }

    public void deletePlayerById(int id) {
        String sql = "DELETE FROM players WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
