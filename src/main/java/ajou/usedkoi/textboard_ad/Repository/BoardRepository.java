package ajou.usedkoi.textboard_ad.Repository;

import ajou.usedkoi.textboard_ad.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository를 상속받으면 기본적인 CRUD 메서드를 사용할 수 있습니다.
    // 필요한 경우 추가적인 쿼리 메서드를 선언할 수 있습니다.
}
