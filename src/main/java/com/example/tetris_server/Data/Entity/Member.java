package com.example.tetris_server.Data.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String username; // 유저이름
    private String password; // password
    private int score; // 최고 점수
}
