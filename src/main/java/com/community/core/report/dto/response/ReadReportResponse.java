package com.community.core.report.dto.response;

import com.community.core.board.infrastructure.BoardRepository;
import com.community.core.member.dto.LoggedInMember;
import com.community.core.report.dto.request.CreateReportRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReadReportResponse {
    private final BoardRepository boardRepository;
    public String reportContent(CreateReportRequest createReportRequest, LoggedInMember member) {
        return "작성자 ID : " + member.getId() +"\r"+
            "작성자 닉네임 : " + member.getUserName() +"\r"+
            "신고받은 userName : " +boardRepository.findById(createReportRequest.getBoardId()).get().getUserName() +"\r"+
            "신고 게시글 id : " +createReportRequest.getBoardId() +"\r"+
            "신고 내용 : "+createReportRequest.getContent();
    }
}