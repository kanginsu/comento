package com.example.comento.Controller;

import com.example.comento.DTO.BoardDTO;
import com.example.comento.Entity.Board;
import com.example.comento.Service.BoardService;
import com.example.comento.Service.BoardServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
private final BoardService boardService;
private final BoardServiceImpl boardServiceImpl;

    public BoardController(BoardService boardService, BoardServiceImpl boardServiceImpl) {
        this.boardService = boardService;
        this.boardServiceImpl = boardServiceImpl;
    }

    @GetMapping("/list")
    public String getBoard(Model model){
        model.addAttribute("board", boardService.readAll());
        return "/board";
    }

    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("board", BoardDTO.builder().build());
        return "/create";
    }

    @PostMapping("")
    public String postCreateOk(@ModelAttribute("board")BoardDTO boardDTO){
        boardService.create(boardDTO);
    return "redirect:/board/list";
}

    @GetMapping("/list/{bno}")
    public String getRead(@PathVariable("bno") Long bno, Model model){
        model.addAttribute("board", boardService.getReadById(bno));
        boardServiceImpl.updateViews(bno);
        return "/read";


}
    @GetMapping("/update/{bno}")
    public String getUpdate(@PathVariable("bno") Long bno, Model model){
        model.addAttribute("board",boardService.getReadById(bno));
        return "/update";
    }

    @PutMapping("/list/{bno}")
    public String putUpdate(@ModelAttribute("bno")BoardDTO board, Model model){
        boardServiceImpl.update(board);
        model.addAttribute(board);
        return "redirect:/board/list";
    }

}
