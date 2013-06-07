package myboard.repository;

import myboard.entity.Board;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 7
 * Time: 오후 1:34
 * To change this template use File | Settings | File Templates.
 */
public interface BoardRepository {
    List<Board> getBoards();

    void addBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int id);
    Board getBoardById(int id);
}
