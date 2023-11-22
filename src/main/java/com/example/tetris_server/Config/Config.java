
package com.example.tetris_server.Config;

import com.example.tetris_server.Repository.JDBCTemplatememberRepository;
import com.example.tetris_server.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {


    private DataSource dataSource;

    @Autowired
    public Config(DataSource dataSource) {
        this.dataSource = dataSource;
    }

/*    @Bean
    public memberService memberservice() {
        return new memberService(memberRepository());
    }*/

    @Bean
    public MemberRepository memberRepository() {
//        return new MemorymemberRepository();
        return new JDBCTemplatememberRepository(dataSource);
    }
/*    @Bean
    public MyDetailsService myDetailsService(){
        return new MyDetailsService(memberRepository());
    }*/
}
