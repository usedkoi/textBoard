package ajou.usedkoi.textboard_ad;

import ajou.usedkoi.textboard_ad.Entity.Board;
import ajou.usedkoi.textboard_ad.Repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
// 실제 데이터베이스를 사용하려면 아래 설정 추가
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") // 테스트용 프로파일을 사용한다면
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 저장 및 조회 테스트")
    public void saveAndFindTest() {
        // 데이터 저장
        Board board = new Board("테스트 제목", "테스트 내용");
        Board savedBoard = boardRepository.save(board);

        // 데이터 조회
        Board foundBoard = boardRepository.findById(savedBoard.getId()).orElse(null);

        // 검증
        assertThat(foundBoard).isNotNull();
        assertThat(foundBoard.getTitle()).isEqualTo("테스트 제목");
        assertThat(foundBoard.getContent()).isEqualTo("테스트 내용");
    }

    @Test
    @DisplayName("모든 게시글 조회 테스트")
    public void findAllTest() {
        // 데이터 저장
        Board board1 = new Board("제목1", "내용1");
        Board board2 = new Board("제목2", "내용2");
        boardRepository.save(board1);
        boardRepository.save(board2);

        // 모든 게시글 조회
        Iterable<Board> boards = boardRepository.findAll();

        // 검증
        assertThat(boards).hasSize(2);
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    public void deleteTest() {
        // 데이터 저장
        Board board = new Board("삭제할 제목", "삭제할 내용");
        Board savedBoard = boardRepository.save(board);

        // 삭제
        boardRepository.deleteById(savedBoard.getId());

        // 검증
        boolean exists = boardRepository.existsById(savedBoard.getId());
        assertThat(exists).isFalse();
    }
}
