package com.community.core.board.dto.request.boardLike;

import com.community.core.board.domain.Board;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBoardLikeRequest {
    private String member_id;
    private Board board;
}