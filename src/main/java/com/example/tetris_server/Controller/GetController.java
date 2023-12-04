package com.example.tetris_server.Controller;

import com.example.tetris_server.Data.DTO.LoginDTO;
import com.example.tetris_server.Data.DTO.RankDTO;
import com.example.tetris_server.Data.DTO.ScoreDTO;
import com.example.tetris_server.Data.Entity.Member;
import com.example.tetris_server.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class GetController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    @ResponseBody
    public String login( LoginDTO loginDTO){
        // isPresent()와 if-else 구문을 사용하여 체크
        if (memberService.login(loginDTO).isPresent()) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("/score")
    @ResponseBody
    public String UpdateScore( ScoreDTO scoreDTO){
        if(memberService.UpdateScore(scoreDTO)){
            return "success";
        }
        return "fail";
    }

    @GetMapping("/rank")
    @ResponseBody
    public List<RankDTO> GetRank(){
        return memberService.GetRank();
    }

}
