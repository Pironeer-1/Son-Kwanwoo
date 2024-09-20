package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.request.CommentUpdateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;
import com.pironeer.week2_1.mapper.CommentMapper;
import com.pironeer.week2_1.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final Map<Long, Comment> commentMap = new HashMap<>();
    private Long commentIdGenerator = 1L;

    public void createComment(Long topicId, CommentCreateRequest request) {
        Long parentCommentId = request.parentCommentId();
        Comment parentComment = null;

        if (parentCommentId != null) {
            parentComment = commentMap.get(parentCommentId);
            if (parentComment == null) {
                throw new RuntimeException("PARENT COMMENT NOT FOUND");
            }
        }

        Comment newComment = CommentMapper.from(request, topicId, commentIdGenerator++);

        if (parentComment != null) {
            parentComment.addChildComment(newComment);
        } else {
            commentMap.put(newComment.getId(), newComment);
        }
    }

    public CommentResponse findById(Long id) {
        Comment comment = commentMap.get(id);
        if (comment == null) {
            throw new RuntimeException("COMMENT NOT FOUND");
        }
        return CommentMapper.toResponse(comment);
    }

    public List<CommentResponse> findAllByTopic(Long topicId) {
        return commentMap.values().stream()
                .filter(comment -> comment.getTopicId().equals(topicId) && comment.getParentCommentId() == null)
                .map(CommentMapper::toResponse)
                .toList();
    }

    public CommentResponse updateComment(CommentUpdateRequest request) {
        Comment existingComment = commentMap.get(request.id());
        if (existingComment == null) {
            throw new RuntimeException("COMMENT NOT FOUND");
        }

        existingComment.setContent(request.content());
        existingComment.setUpdatedAt(java.time.LocalDateTime.now());
        return CommentMapper.toResponse(existingComment);
    }

    public void deleteById(Long id) {
        Comment comment = commentMap.get(id);
        if (comment == null) {
            throw new RuntimeException("COMMENT NOT FOUND");
        }

        if (!comment.getChildComments().isEmpty()) {
            comment.getChildComments().clear();
        }

        if (comment.getParentCommentId() != null) {
            Comment parentComment = commentMap.get(comment.getParentCommentId());
            if (parentComment != null) {
                parentComment.getChildComments().removeIf(c -> c.getId().equals(id));
            }
        }

        commentMap.remove(id);
    }
}