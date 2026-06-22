package sping.revision.playermngmnt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;

public class Player {
    @NotNull(message = "Player Id is required")
    @Positive(message = "Player Id must be positive")
    private Integer id;
    @NotBlank(message = "Player name is required")
    private String name;
    @NotBlank(message = "Position is required")
    private String position;
    @NotNull(message = "Player Id is required")
    @Positive(message = "Player Id must be positive")
    private Integer age;

    public Player(int id, String name, String position, Integer age) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
