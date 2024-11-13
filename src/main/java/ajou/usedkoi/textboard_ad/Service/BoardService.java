package ajou.usedkoi.textboard_ad.Service;

import ajou.usedkoi.textboard_ad.Entity.Board;
import ajou.usedkoi.textboard_ad.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired  // 생성자 주입
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 모든 게시글 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    // 게시글 저장
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    // ID로 게시글 조회
    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    // 게시글 삭제
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
