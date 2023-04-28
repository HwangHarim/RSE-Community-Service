package com.community.core.comment.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadCommentRequest {
    Long id;
    Long boardId;
    String comment;
    Long likeView;
}