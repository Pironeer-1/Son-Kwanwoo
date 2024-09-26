package com.pironeer.myTempalate.board.service;

import com.pironeer.myTempalate.board.dto.request.BoardCreateRequest;
import com.pironeer.myTempalate.board.dto.request.BoardUpdateRequest;
import com.pironeer.myTempalate.board.dto.response.BoardResponse;
import com.pironeer.myTempalate.board.entity.Board;
import com.pironeer.myTempalate.board.mapper.BoardMapper;
import com.pironeer.myTempalate.board.repository.BoardRepository;
import com.pironeer.myTempalate.global.exception.CustomException;
import com.pironeer.myTempalate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long save(BoardCreateRequest request) {
        Board savedBoard = boardRepository.save(BoardMapper.from(request));
        return savedBoard.getId();
    }

    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));  // 커스텀 예외 적용
        return BoardResponse.of(board);
    }

    public List<BoardResponse> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponse::of).toList();
    }

    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));  // 커스텀 예외 적용
        boardRepository.save(board.update(request));
        return BoardResponse.of(board);
    }

    public Long deleteById(Long id) {
        Long deleteId = boardRepository.deleteById(id);
        return deleteId;
    }
}
