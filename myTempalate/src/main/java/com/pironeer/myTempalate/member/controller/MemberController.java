package com.pironeer.myTempalate.member.controller;

import com.pironeer.myTempalate.global.dto.response.SuccessResponse;
import com.pironeer.myTempalate.global.dto.response.result.SingleResult;
import com.pironeer.myTempalate.global.dto.response.JwtTokenSet;
import com.pironeer.myTempalate.member.dto.request.MemberSignupReq;
import com.pironeer.myTempalate.member.dto.request.MemberLoginReq;
import com.pironeer.myTempalate.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "회원(Member)")
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<JwtTokenSet>> register(@Valid @RequestBody MemberSignupReq req) {
        SingleResult<JwtTokenSet> result = memberService.register(req);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public SuccessResponse<SingleResult<JwtTokenSet>> login(@Valid @RequestBody MemberLoginReq req) {
        SingleResult<JwtTokenSet> result = memberService.login(req);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃")
    public SuccessResponse<SingleResult<String>> logout(@RequestAttribute("id") Long memberId) {
        SingleResult<String> result = memberService.logout(memberId);
        return SuccessResponse.ok(result);
    }
}
