package sesac.jpaPractice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.jpaPractice.domain.Board;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // jpa 기본 함수를 사용하기 때문에 아무것도 없음
    // Integer는 findById를 사욯하기 위해

    List<Board> findByTitle(String title);

    void deleteByWriter(String writer);
    // delete from board where writer = #{writer}
}
