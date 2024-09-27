package com.pironeer.myTempalate.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record MemberLogoutReq (
        @NotBlank
        @Schema(description = "회원 id", example = "id")
        String memberId
) {}
