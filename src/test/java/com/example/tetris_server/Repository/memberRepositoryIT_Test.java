package com.example.tetris_server.Repository;

import com.example.tetris_server.Data.Domain.User;
import com.example.tetris_server.Data.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class memberRepositoryIT_Test {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void 저장_test() {
        User user = new User();
        String id = "20200013";
        user.setId(id);

        memberRepository.save(user);

        assertThat(user.getId())
                .isEqualTo(memberRepository.findbyid(id).get().getId());
    }

}
