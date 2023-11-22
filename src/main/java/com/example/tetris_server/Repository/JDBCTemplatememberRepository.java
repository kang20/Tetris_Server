package com.example.tetris_server.Repository;

import com.example.tetris_server.Data.Entity.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JDBCTemplatememberRepository implements MemberRepository {


    private JdbcTemplate jdbcTemplate;


    public JDBCTemplatememberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Member save(Member member) {
        // SQL query를 정의
        String sql = "INSERT INTO MEMBER (USERNAME, PASSWORD, SCORE) VALUES (?, ?, ?)";
        // SQL query 실행
        jdbcTemplate.update(sql, member.getUsername(), member.getPassword(), member.getScore());
        return member;
    }

    @Override
    public Optional<Member> findByPassword(String password) {
        String sql = "SELECT * FROM member where PASSWORD=?";
        List<Member> result = jdbcTemplate.query(sql,memberRowMapper(),password);

        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        String sql = "SELECT * FROM member where name=?";
        List<Member> result = jdbcTemplate.query(sql, memberRowMapper(), name);
        return result.stream().findAny();
    }


    private RowMapper<Member> memberRowMapper() {
        return (rs,rowNum) ->{
            Member member = new Member();
            member.setUsername(rs.getString("NAME"));
            member.setPassword(rs.getString("PASSWORD"));
            member.setScore(rs.getInt("SCORE"));
            return member;
        };
    }
}
