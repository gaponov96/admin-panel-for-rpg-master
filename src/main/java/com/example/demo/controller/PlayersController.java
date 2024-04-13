package com.example.demo.controller;

import com.example.demo.dao.PlayerDao;
import com.example.demo.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayersController {

    private final PlayerDao playerDao;
    @GetMapping("/getPlayers")
    public List<Player> getPlayers() {
        return playerDao.getAllPlayers();
    }

    @PostMapping("/addPlayer")
    public ResponseEntity<String> addNewPlayer(@RequestBody Player player) {
        playerDao.addNewPlayer(player);
        return ResponseEntity.status(200).body("Вы создали игрока");
    }

    @PostMapping("/updatePlayer")
    public ResponseEntity<String> updatePlayer(@RequestBody Player player) {
        Player existingPlayer = playerDao.getPlayerById(player.getId());
        if (existingPlayer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Игрок с ID " + player.getId() + " не найден");
        }
        playerDao.updatePlayer(player);
        return ResponseEntity.status(HttpStatus.OK).body("Вы обновили игрока" + "id: " + player.getId() + " " + player.getName());
    }

    @PostMapping("/delPlayer")
    public ResponseEntity<String> delPlayer(@RequestParam int id) {
        playerDao.deletePlayerById(id);
        return ResponseEntity.status(200).body("Вы удалили игрока");
    }
}
