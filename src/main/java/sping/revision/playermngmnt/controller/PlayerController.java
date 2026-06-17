package sping.revision.playermngmnt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sping.revision.playermngmnt.model.Player;

@RestController
public class PlayerController {

    @GetMapping("/players")
    public Player getPlayers() {
        return new Player(
                1,
                "Pranshu",
                "Forward",
                "Ronaldo",
                "Kinu@123456"
        );
    }
}


