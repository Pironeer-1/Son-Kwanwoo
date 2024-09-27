package com.pironeer.myTempalate.board.controller;

import com.pironeer.myTempalate.board.dto.request.BoardCreateRequest;
import com.pironeer.myTempalate.board.dto.request.BoardUpdateRequest;
import com.pironeer.myTempalate.board.dto.response.BoardResponse;
import com.pironeer.myTempalate.board.service.BoardService;
import com.pironeer.myTempalate.global.dto.response.SuccessResponse;
import com.pironeer.myTempalate.global.dto.response.result.ListResult;
import com.pironeer.myTempalate.global.dto.response.result.SingleResult;
import com.pironeer.myTempalate.global.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시물(Board)")
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;
    private final ResponseService responseService;

    @PostMapping
    @Operation(summary = "게시물 작성")
    public SuccessResponse<SingleResult<Long>> create(
            @RequestAttribute("id") String userId,
            @Valid @RequestBody BoardCreateRequest request
    ) {
        System.out.println(userId);

        SingleResult<Long> save = responseService.getSingleResult(boardService.save(request));
        return SuccessResponse.ok(save);
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "게시물 단건 조회")
    public SuccessResponse<SingleResult<BoardResponse>> read(@PathVariable("boardId") Long id) {
        SingleResult<BoardResponse> result = responseService.getSingleResult(boardService.findById(id));
        return SuccessResponse.ok(result);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public SuccessResponse<ListResult<BoardResponse>> readAll() {
        ListResult<BoardResponse> result = responseService.getListResult(boardService.findAll());
        return SuccessResponse.ok(result);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public SuccessResponse<SingleResult<BoardResponse>> update(@Valid @RequestBody BoardUpdateRequest request) {
        SingleResult<BoardResponse> response = responseService.getSingleResult(boardService.update(request));
        return SuccessResponse.ok(response);
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "게시물 삭제")
    public SuccessResponse<SingleResult<Long>> remove(@PathVariable("boardId") Long id) {
        SingleResult<Long> deletedId = responseService.getSingleResult(boardService.deleteById(id));
        return SuccessResponse.ok(deletedId);
    }
}
