package com.pironeer.myTempalate.board.controller;

import com.pironeer.myTempalate.board.dto.request.BoardCreateRequest;
import com.pironeer.myTempalate.board.dto.request.BoardUpdateRequest;
import com.pironeer.myTempalate.board.dto.response.BoardResponse;
import com.pironeer.myTempalate.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시물(Board)")
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    @Operation(summary = "게시물 작성")
    public ResponseEntity<Long> create(
            @RequestAttribute("id") String userId,
            @Valid @RequestBody BoardCreateRequest request
    ) {
        System.out.println(userId);

        Long save = boardService.save(request);
        return ResponseEntity.ok().body(save);
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "게시물 단건 조회")
    public ResponseEntity<BoardResponse> read(@PathVariable("boardId") Long id) {
        BoardResponse result = boardService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public ResponseEntity<List<BoardResponse>> readAll() {
        List<BoardResponse> result = boardService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<BoardResponse> update(@Valid @RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<Long> remove(@PathVariable("boardId") Long id) {
        Long deletedId = boardService.deleteById(id);
        return ResponseEntity.ok().body(deletedId);
    }
}