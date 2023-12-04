package com.example.tetris_server.Repository;

import com.example.tetris_server.Data.Domain.User;
import com.example.tetris_server.Data.Entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    User save(User user);


    Optional<User> findbyid(String id);

    List<User> findAll();

    void UpdateScore(String id ,int maxscore);

    void UpdateWin(String id , int wind );
    void UpdateFault(String id,int fault);

    List<User> RankTen();

}
