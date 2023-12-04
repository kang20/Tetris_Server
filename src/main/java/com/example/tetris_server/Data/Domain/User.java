package com.example.tetris_server.Data.Domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private int maxscore;
    private int win;
    private int fault;
}
