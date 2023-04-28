package com.community.core.board.infrastructure;

import com.community.core.board.domain.BoardLike;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {
    Optional<BoardLike> findByBoardIdAndMemberId(Long boardId, String memberId);
    List<BoardLike> findByMemberId(String memberId);
}
