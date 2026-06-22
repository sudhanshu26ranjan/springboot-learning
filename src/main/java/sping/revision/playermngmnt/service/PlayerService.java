package sping.revision.playermngmnt.service;

import org.springframework.stereotype.Service;
import sping.revision.playermngmnt.model.Player;

import java.util.List;

@Service
public class PlayerService {

    public PlayerService() {
        System.out.println("PlayerService instantiated!");
    }

    public Player createPlayer(Player player) {
        System.out.println("PlayerService.createPlayer() called");
        if (player.getAge() < 5) {

            throw new RuntimeException(
                    "Player age must be at least 5"
            );
        }
        return player;
    }

    public List<Player> getPlayer() {
        return List.of(
                new Player(1,"Pranshu", "Forward", 5),
                new Player(2, "Messi", "Forward", 33),
                new Player(3, "Ronaldo", "Forward", 41)
                );
    }
}
