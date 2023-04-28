package com.community.core.member.presentation.user;


import com.community.core.common.response.dto.ResponseDto;
import com.community.core.common.response.dto.ResponseMessage;
import com.community.core.common.response.handler.ResponseHandler;
import com.community.core.member.application.UserService;
import com.community.core.member.dto.LoggedInMember;
import com.community.core.member.dto.request.UpdateUserName;
import com.community.core.member.infrastructure.annotation.AuthMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseHandler responseHandler;

    @GetMapping("/me")
    public ResponseEntity<ResponseDto> getUser(@AuthMember LoggedInMember loggedInMember){
        LoggedInMember user = userService.viewUser(loggedInMember.getId());
        return responseHandler.toResponseEntity(ResponseMessage.USER_INFO, user);
    }

    @PatchMapping
    public ResponseEntity<ResponseDto> updateUserName(@AuthMember LoggedInMember loggedInMember, @RequestBody
    UpdateUserName updateUserName){
        userService.updateUserName(loggedInMember.getId(), updateUserName);
        return responseHandler.toResponseEntity(ResponseMessage.UPDATE_USER_NAME,"userName 변경 완료.");
    }
}