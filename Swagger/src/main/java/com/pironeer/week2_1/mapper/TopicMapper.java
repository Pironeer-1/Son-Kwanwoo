package com.pironeer.week2_1.mapper;

import com.pironeer.week2_1.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.repository.domain.Topic;

import java.time.LocalDateTime;

public class TopicMapper {

    /**
     * TopicCreateRequest를 Topic 엔티티로 변환하는 메서드.
     * @param request 클라이언트로부터 받은 주제 생성 요청 DTO
     * @return 변환된 Topic 엔티티
     */
    public static Topic from(TopicCreateRequest request) {
        // 현재 시간을 생성 (생성일과 수정일에 동일하게 사용)
        LocalDateTime now = LocalDateTime.now();

        // 빌더 패턴을 사용해 Topic 엔티티 객체를 생성하고,
        // 요청에서 받은 제목과 내용을 설정, 현재 시간을 생성 및 수정 시간으로 설정.
        return Topic.builder()
                .title(request.title()) // 제목 설정
                .content(request.content()) // 내용 설정
                .createdAt(now) // 생성 시간 설정
                .updatedAt(now) // 수정 시간 설정
                .build(); // Topic 객체 생성
    }
}
