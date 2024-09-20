package com.pironeer.week2_1.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CommentCreateRequest(
        @NotBlank
        @Schema(description = "댓글 내용", example = "댓글입니다.")
        String content,

        @Schema(description = "대댓글의 부모 댓글 ID", example = "1")
        Long parentCommentId // 대댓글일 경우 부모 댓글 ID, 없으면 null
) {
}
