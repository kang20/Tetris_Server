package com.example.tetris_server.Repository;

import com.example.tetris_server.Data.Domain.User;
import com.example.tetris_server.Data.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class memberRepositoryIT_Test {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 저장_test() {
        User user = new User();
        user.setId("20200013");

        memberRepository.save(user);

        assertThat(user.getId())
                .isEqualTo(memberRepository.findbyid("ID").get().getId());
    }





}
