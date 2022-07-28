package com.example.comento.Service;

import com.example.comento.DTO.BoardDTO;
import com.example.comento.Entity.Board;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface BoardService {
 void create(BoardDTO board);
 List<Board> readAll();
 Board getReadById(Long bno);
 int updateViews(Long bno);
 void update(BoardDTO board);
 void delete(Long bno);
}
