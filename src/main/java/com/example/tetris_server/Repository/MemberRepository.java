package com.example.tetris_server.Repository;

import com.example.tetris_server.Data.Entity.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);


    Optional<Member> findByPassword(String password);


    Optional<Member> findByName(String name);
}
