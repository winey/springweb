package myboard.repository;

import myboard.domain.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 22
 * Time: 오전 11:07
 * To change this template use File | Settings | File Templates.
 */
public class BoardDBRepository implements BoardRepository {

    private static BoardDBRepository instance = new BoardDBRepository();


    public static BoardDBRepository getInstance() {
        return instance;
    }
    public BoardDBRepository() {
    }

    @Override
    public List<Board> getBoards() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id, writer, pw, title, content from board";
        List<Board> boards = new ArrayList<Board>();

        try {
            conn = DBConnect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Board board = new Board();
                board.setId(rs.getInt("id"));
                board.setWriter(rs.getString("writer"));
                board.setPw(rs.getString("pw"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));

                boards.add(board);
            }

            DBDisconnect(rs, pstmt, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBDisconnect(rs, pstmt, conn);
        }

        return boards;
    }

    @Override
    public void addBoard(Board board) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "insert into board (writer, pw, title, content) values (?, ?, ?, ?)";

        try {
            conn = DBConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getWriter());
            pstmt.setString(2, board.getPw());
            pstmt.setString(3, board.getTitle());
            pstmt.setString(4, board.getContent());
            int cnt= pstmt.executeUpdate();
            DBDisconnect(rs, pstmt, conn);

            System.out.println("cnt = " + cnt);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBDisconnect(rs, pstmt, conn);
        }

    }

    @Override
    public void updateBoard(Board board) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update board set writer=?, pw=?, title=?, content=? where id=?";

        try {
            conn = DBConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getWriter());
            pstmt.setString(2, board.getPw());
            pstmt.setString(3, board.getTitle());
            pstmt.setString(4, board.getContent());
            pstmt.setInt(5, board.getId());
            int cnt= pstmt.executeUpdate();
            DBDisconnect(rs, pstmt, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBDisconnect(rs, pstmt, conn);
        }

    }

    @Override
    public void deleteBoard(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "delete from board where id=?";

        try {
            conn = DBConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            DBDisconnect(rs, pstmt, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBDisconnect(rs, pstmt, conn);
        }


    }

    @Override
    public Board getBoardById(int id) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id, writer, pw, title, content from board where id=?";

        Board board = new Board();
        try {
            conn = DBConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                board.setId(rs.getInt("id"));
                board.setWriter(rs.getString("writer"));
                board.setPw(rs.getString("pw"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
            }

            DBDisconnect(rs, pstmt, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBDisconnect(rs, pstmt, conn);
        }

        return board;
    }

    public Connection DBConnect() {
        String url = "jdbc:postgresql://localhost:5432/myboard";
        String usr = "myboard";
        String pwd = "myboard";

        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void DBDisconnect (ResultSet rs, PreparedStatement pstmt, Connection conn) {

        try {

            if(rs != null) { rs.close(); }
            if(pstmt != null) { pstmt.close(); }
            if(conn != null) { conn.close(); }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
