package com.pironeer.week2_1.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Comment {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long topicId;
    private Long parentCommentId; // 부모 댓글 ID (대댓글일 경우)
    private List<Comment> childComments;

    @Builder
    public Comment(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Long topicId, Long parentCommentId) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.topicId = topicId;
        this.parentCommentId = parentCommentId;
        this.childComments = new ArrayList<>();
    }

    public void addChildComment(Comment comment) {
        this.childComments.add(comment);
    }
}
