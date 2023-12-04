package com.example.tetris_server.Repository;

import com.example.tetris_server.Data.Domain.User;
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
    public User save(User user) {
        // SQL query를 정의
        String sql = "INSERT INTO user (id) VALUES (?)";
        // SQL query 실행
        jdbcTemplate.update(sql, user.getId());
        return user;
    }

    @Override
    public Optional<User> findbyid(String id) {
        String sql = "SELECT * FROM user where id=?";
        List<User> result = jdbcTemplate.query(sql,memberRowMapper(),id);

        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return  jdbcTemplate.query(sql,memberRowMapper());
    }

    @Override
    public void UpdateScore(String id, int maxscore) {
        String SQL = "UPDATE user SET maxscore = (?) WHERE id = (?)";
        jdbcTemplate.update(SQL, maxscore, id);
    }

    @Override
    public void UpdateWin(String id,int win) {
        String SQL = "UPDATE user SET win = ? WHERE id = ?";
        jdbcTemplate.update(SQL, win+1, id);
    }

    @Override
    public void UpdateFault(String id,int fault) {
        String SQL = "UPDATE user SET fault = ? WHERE id = ?";
        jdbcTemplate.update(SQL, fault+1, id);
    }

    @Override
    public List<User> RankTen() {
        String sql = "SELECT * FROM user ORDER BY maxscore DESC LIMIT 10";
        List<User> result = jdbcTemplate.query(sql,memberRowMapper());


        return result;
    }

    private RowMapper<User> memberRowMapper() {
        return (rs,rowNum) ->{
            User user = new User();
            user.setId(rs.getString("id"));
            user.setMaxscore(rs.getInt("maxscore"));
            user.setWin(rs.getInt("win"));
            user.setFault(rs.getInt("fault"));

            return user;
        };
    }
}
