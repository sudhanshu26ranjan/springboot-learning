package sping.revision.playermngmnt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}


