package com.community.core.report.controller;

import com.community.core.common.response.dto.ResponseDto;
import com.community.core.common.response.dto.ResponseMessage;
import com.community.core.common.response.handler.ResponseHandler;
import com.community.core.member.dto.LoggedInMember;
import com.community.core.member.infrastructure.annotation.AuthMember;
import com.community.core.report.application.ReportService;
import com.community.core.report.dto.request.CreateReportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService slackService;

    private final ResponseHandler responseHandler;

    @PostMapping
    public ResponseEntity<ResponseDto> postReport(
        @AuthMember LoggedInMember loggedInMember,
        @RequestBody CreateReportRequest createReportRequest){
        slackService.postSlackMessage(createReportRequest, loggedInMember);
        return responseHandler.toResponseEntity(
            ResponseMessage.CREATE_BOARD_SUCCESS,
            "신고가 완료 되었습니다.");
    }
}