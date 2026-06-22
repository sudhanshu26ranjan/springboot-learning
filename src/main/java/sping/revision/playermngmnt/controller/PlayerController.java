package sping.revision.playermngmnt.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sping.revision.playermngmnt.exception.PlayerNotFoundException;
import sping.revision.playermngmnt.model.Player;
import sping.revision.playermngmnt.service.PlayerService;

import java.util.List;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getPlayer();
    }

    @GetMapping("/players/{id}")
    public String getPlayer(
            @PathVariable Integer id) {

        throw new PlayerNotFoundException(
                "Player not found with id "
                        + id
        );
    }

    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player){
        return player;
    }

    @GetMapping("/test")
    public String testException() {
        throw new RuntimeException("Something Went Wrong...");
    }
}


