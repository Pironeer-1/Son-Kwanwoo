package com.pironeer.myTempalate.member.service;

import com.pironeer.myTempalate.global.dto.response.JwtTokenSet;
import com.pironeer.myTempalate.global.dto.response.result.SingleResult;
import com.pironeer.myTempalate.global.exception.CustomException;
import com.pironeer.myTempalate.global.exception.ErrorCode;
import com.pironeer.myTempalate.global.service.AuthService;
import com.pironeer.myTempalate.global.service.ResponseService;
import com.pironeer.myTempalate.member.dto.request.MemberSignupReq;
import com.pironeer.myTempalate.member.dto.request.MemberLoginReq;
import com.pironeer.myTempalate.member.entity.Member;
import com.pironeer.myTempalate.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthService authService;
    private final ResponseService responseService;

    public SingleResult<JwtTokenSet> register(MemberSignupReq req) {
        if (memberRepository.existByMemberId(req.memberId())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }

        Member newMember = Member.builder()
                .memberId(req.memberId())
                .password(req.password())
                .name(req.name())
                .build();
        newMember = memberRepository.save(newMember);
        log.info(newMember.getMemberId());

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());

        return responseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> login(MemberLoginReq req) {
        Member member = memberRepository.findByMemberId(req.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        if (!member.getPassword().equals(req.password())) {
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());

        return responseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<String> logout(Long memberId) {
        log.info("User ID {} logged out", memberId);
        return responseService.getSingleResult("로그아웃 완료");
    }
}
