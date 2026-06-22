package sping.revision.playermngmnt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;

public class Player {
    @NotNull(message = "Player Id is required")
    @Positive(message = "Player Id must be positive")
    private int id;
    @NotBlank(message = "Player name is required")
    private String name;
    @NotBlank(message = "Position is required")
    private String position;

    public Player(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
