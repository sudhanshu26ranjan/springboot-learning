package sping.revision.playermngmnt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Player {
    private final int id;
    private final String name;
    private final String position;
    private final String nickName;
    @JsonIgnore
    private final String password;

    public Player(int id, String name, String position, String nickName, String password) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.nickName = nickName;
        this.password = password;
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

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }
}
