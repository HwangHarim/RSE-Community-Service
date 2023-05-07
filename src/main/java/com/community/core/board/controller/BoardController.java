package com.community.core.board.controller;

import com.community.core.board.application.BoardService;
import com.community.core.board.domain.vo.Type;
import com.community.core.board.dto.request.board.CreateBoardRequest;
import com.community.core.board.dto.request.board.UpdateBoardRequest;
import com.community.core.board.dto.response.board.ReadBoardResponse;
import com.community.core.common.response.dto.ResponseDto;
import com.community.core.common.response.dto.ResponseMessage;
import com.community.core.common.response.handler.ResponseHandler;
import com.community.core.member.dto.LoggedInMember;
import com.community.core.member.infrastructure.annotation.AuthMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("board")
@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final ResponseHandler responseHandler;

    @ApiOperation("board 전체 검색")
    @GetMapping(produces = "application/json")
    public ResponseEntity<ResponseDto> getAllBoards(
        @PageableDefault(sort ="id", size = 15,direction= Direction.ASC)
        Pageable pageable,
        @RequestParam(value = "type", required = false) String type,
        @RequestParam(value = "title", required = false) String title){
        if(type != null){
            Page<ReadBoardResponse> boards = boardService.getTypeBoards(pageable, Type.getType(type));
            return responseHandler.toResponseEntity(
                ResponseMessage.READ_ALL_BOARD_SUCCESS,
                boards
            );
        }
        if(title != null){
            Page<ReadBoardResponse> boards = boardService.getTitleBoards(pageable, title);
            return responseHandler.toResponseEntity(
                ResponseMessage.READ_ALL_BOARD_SUCCESS,
                boards
            );
        }
        Page<ReadBoardResponse> boards = boardService.getAllBoards(pageable);
        return responseHandler.toResponseEntity(
            ResponseMessage.READ_ALL_BOARD_SUCCESS,
            boards
        );
    }

    @ApiOperation("board 생성")
    @PostMapping
    public ResponseEntity<ResponseDto> postBoard(@AuthMember LoggedInMember loggedInMember, @RequestBody CreateBoardRequest createBoardRequest){
        boardService.createBoard(createBoardRequest, loggedInMember.getId());
        return responseHandler.toResponseEntity(
            ResponseMessage.CREATE_BOARD_SUCCESS,
            "board 생성이 완료 되었습니다."
        );
    }

    @ApiOperation("board 검색")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> getBoard(@PathVariable("id") Long id,
        @AuthMember LoggedInMember loggedInMember){
       ReadBoardResponse board = boardService.findBoard(id, loggedInMember);
        return responseHandler.toResponseEntity(
            ResponseMessage.READ_BOARD_SUCCESS,
            board
        );
    }

    @ApiOperation("board 수정")
    @PatchMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> updateBoard(@PathVariable("id") Long id,
        @RequestBody UpdateBoardRequest updateBoardRequest,
        @AuthMember LoggedInMember loggedInMember){
        boardService.updateBoard(id, loggedInMember, updateBoardRequest);
        return responseHandler.toResponseEntity(
            ResponseMessage.UPDATE_BOARD_SUCCESS,
            "board 수정이 완료 되었습니다."
        );
    }

    @ApiOperation("board 삭제")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> deleteBoard(
        @PathVariable("id") Long id,
        @AuthMember LoggedInMember loggedInMember) {
      boardService.deleteBoard(id, loggedInMember);
      return responseHandler.toResponseEntity(
          ResponseMessage.DELETE_BOARD_SUCCESS,
          "board 삭제 완료 되었습니다."
      );
    }
}