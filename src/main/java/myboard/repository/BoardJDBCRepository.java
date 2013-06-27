package myboard.repository;

import myboard.domain.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 22
 * Time: 오전 11:07
 * To change this template use File | Settings | File Templates.
 */
public class BoardJDBCRepository implements BoardRepository {


    //private NamedParameterJdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public BoardJDBCRepository() {
    }
    public BoardJDBCRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Board> getBoards() {
        return jdbcTemplate.query(
            "select id, writer, pw, title, content from board",
            new Object[] {},
            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int i) throws SQLException {
                    Board board = new Board();
                    board.setId(rs.getInt("id"));
                    board.setWriter(rs.getString("writer"));
                    board.setPw(rs.getString("pw"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));

                    return board;
                }
            }
        );
    }

    @Override
    public void addBoard(Board board) {
        jdbcTemplate.update(
            "insert into board (writer, pw, title, content) values (?, ?, ?, ?)",
            new Object[] {
                board.getWriter(),
                board.getPw(),
                board.getTitle(),
                board.getContent()
            }
        );
    }

    @Override
    public void updateBoard(Board board) {
        jdbcTemplate.update(
            "update board set writer=?, pw=?, title=?, content=? where id=?",
            new Object[] {
                board.getWriter(),
                board.getPw(),
                board.getTitle(),
                board.getContent(),
                board.getId()
            }
        );

    }

    @Override
    public void deleteBoard(int id) {
        jdbcTemplate.update(
            "delete from board where id=?",
            new Object[] {id}
        );
    }

    @Override
    public Board getBoardById(int id) {
        return jdbcTemplate.queryForObject(
            "select id, writer, pw, title, content from board where id=?",
            new Object[] {id},
            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int i) throws SQLException {
                    Board board = new Board();
                    board.setId(rs.getInt("id"));
                    board.setWriter(rs.getString("writer"));
                    board.setPw(rs.getString("pw"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    return board;
                }
            }
        );
    }
}
