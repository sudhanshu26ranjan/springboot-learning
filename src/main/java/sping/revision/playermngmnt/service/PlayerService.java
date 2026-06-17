package sping.revision.playermngmnt.service;

import org.springframework.stereotype.Service;
import sping.revision.playermngmnt.model.Player;

import java.util.List;

@Service
public class PlayerService {
    public List<Player> getPlayer() {
        return List.of(
                new Player(1,"Pranshu", "Forward", "Champ", "Kinu@123456"),
                new Player(2, "Messi", "Forward", "magic", "magic10"),
                new Player(3, "Ronaldo", "Forward", "goal machine", "CR7")
                );
    }
}
