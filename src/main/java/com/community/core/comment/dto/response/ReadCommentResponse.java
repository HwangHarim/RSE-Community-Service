package com.community.core.comment.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReadCommentResponse {
    Long id;
    String userName;
    Long boardId;
    String comment;
    boolean mine;
    Long likeView;
}