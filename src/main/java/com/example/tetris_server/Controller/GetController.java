package com.example.tetris_server.Controller;

import com.example.tetris_server.Data.DTO.ScoreDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GetController {


    @PostMapping("/")
    @ResponseBody
    public String test(@RequestBody ScoreDTO scoreDTO) {
        System.out.println(scoreDTO.getScore());
        return "sdfa";
    }

/*        private memberService memberservice;

        @Autowired
        public GetPageController(memberService memberService) {
            this.memberservice = memberService;
        }




        @GetMapping("/") // main page
        public String main_page() {
            return "navar";
        }

        @GetMapping("/signup") // 회원 가입 페이지
        public String signup_page() {
            return "/member/signup";
        }


        @GetMapping("/login") // 로그인 페이지
        public String login_get(login_form login_form) {

            return "/member/login";
        }
        @GetMapping("/user") // 임시 권한 적용 페이지
        public String user_get(){
            return "user_access";
        }
        @GetMapping("/game") // game 페이지
        public String test(){
            return "game";
        }*/


/*    }*/

}
