package com.example.tetris_server.Service;


import com.example.tetris_server.Data.DTO.LoginDTO;
import com.example.tetris_server.Data.DTO.RankDTO;
import com.example.tetris_server.Data.DTO.ScoreDTO;
import com.example.tetris_server.Data.Domain.User;
import com.example.tetris_server.Repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    public Optional<User> login(LoginDTO loginDTO){
        Optional<User> user =   memberRepository.findbyid(loginDTO.getId());
        return user;
    }
    public boolean UpdateScore(ScoreDTO scoreDTO){
        User user = memberRepository.findbyid(scoreDTO.getId()).get();
        if(user.getMaxscore() < scoreDTO.getScore()){
            memberRepository.UpdateScore(scoreDTO.getId(), scoreDTO.getScore());
            return true;
        }
        else{
            return false;
        }
    }
    public List<RankDTO> GetRank(){
        List<User> result = memberRepository.RankTen();
        List<RankDTO> ran = new ArrayList<RankDTO>();
        result.stream().forEach(item -> {
            RankDTO r = new RankDTO();
            r.setId(item.getId());
            r.setMaxscore(item.getMaxscore());
            ran.add(r);
        });
        return ran;
    }





}
