package com.example.comento.Service;


import com.example.comento.DTO.BoardDTO;
import com.example.comento.Entity.Board;
import com.example.comento.Repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void create(BoardDTO board) {
        Board entity = Board.builder()
                .bno(board.getBno())
                .name(board.getName())
                .context(board.getContext())
                .title(board.getTitle())
                .views(board.getViews())
                .build();
        boardRepository.save(entity);
    }

    @Transactional
    public int updateViews(Long bno) {
        return boardRepository.updateViews(bno);
    }

    @Override
    public void update(BoardDTO board) {
        Board Entity = Board.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .context(board.getContext())
                .name(board.getName())
                .views(board.getViews())
                .build();
        boardRepository.save(Entity);
    }

    @Override
    public void delete(Long bno) {
        boardRepository.deleteById(bno);
    }

    @Transactional
    public List<Board> readAll() {
        List<Board> Board = boardRepository.findAll();
        return Board;
    }

    @Override
    public Board getReadById(Long bno) {
        return boardRepository.findById(bno).orElse(null);
    }
}
