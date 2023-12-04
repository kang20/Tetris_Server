package com.example.tetris_server.Data.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultiMessage {
    public String id;
    public int cur_block;
    public int next_block;
    public int [][]map;
    public boolean gameover;
    public int curscore;
}
