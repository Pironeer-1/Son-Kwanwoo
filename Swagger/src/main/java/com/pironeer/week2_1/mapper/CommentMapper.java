package com.pironeer.week2_1.mapper;

import com.pironeer.week2_1.domain.Comment;
import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;

import java.time.LocalDateTime;

public class CommentMapper {
    public static Comment from(CommentCreateRequest request, Long topicId, Long commentId) {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
                .id(commentId)
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .topicId(topicId)
                .parentCommentId(request.parentCommentId())
                .build();
    }
    public static CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .childComments(comment.getChildComments().stream()
                        .map(CommentMapper::toResponse)
                        .toList())
                .build();
    }
}
