package com.pironeer.myTempalate.board.mapper;

import com.pironeer.myTempalate.board.dto.request.BoardCreateRequest;
import com.pironeer.myTempalate.board.entity.Board;

import java.time.LocalDateTime;

public class BoardMapper {
    public static Board from(BoardCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Board.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
