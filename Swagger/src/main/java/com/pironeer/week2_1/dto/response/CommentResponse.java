package com.pironeer.week2_1.dto.response;

import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public class CommentResponse {

    @Schema(description = "댓글 ID", example = "1")
    private Long id;

    @Schema(description = "댓글 내용", example = "댓글입니다.")
    private String content;

    @Schema(description = "댓글 생성 시간", example = "2023-09-10T14:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "댓글 수정 시간", example = "2023-09-10T15:00:00")
    private LocalDateTime updatedAt;

    @Schema(description = "대댓글 리스트")
    private List<CommentResponse> childComments;
}
