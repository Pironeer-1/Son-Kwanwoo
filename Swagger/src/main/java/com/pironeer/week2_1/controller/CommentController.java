package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.request.CommentUpdateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;
import com.pironeer.week2_1.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글(Comment)")
@RequestMapping("/api/topic/{topicId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> createComment(@PathVariable Long topicId, @RequestBody CommentCreateRequest request) {
        commentService.createComment(topicId, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<?> updateComment(@RequestBody CommentUpdateRequest request) {
        commentService.updateComment(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "댓글 조회")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long topicId) {
        List<CommentResponse> responses = commentService.findAllByTopic(topicId);
        return ResponseEntity.ok(responses);
    }
}
