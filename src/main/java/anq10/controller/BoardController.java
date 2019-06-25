package anq10.controller;

import anq10.dto.BoardDataDTO;
import anq10.model.Board;
import anq10.repository.BoardRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/")
    public List<Board> index() throws NullPointerException {
        return boardRepository.findAll();
    }

    @PostMapping("/")
    public void add(@ModelAttribute BoardDataDTO boardDataDTO) throws NullPointerException {
        Board newBoard = Board.builder().name(boardDataDTO.getName())
                .categories(boardDataDTO.getCategories())
                .tags(boardDataDTO.getTags())
                .build();
        System.out.println("-------------------------------");
        System.out.printf("board %s is now added", boardDataDTO.getName());
        System.out.println("-------------------------------");
        boardRepository.save(newBoard);
    }

    @PostMapping("/{boardId}/delete")
    public void delete(@PathVariable String boardId) {
        Board boardToDelete = boardRepository.findOne(Long.valueOf(boardId));
        System.out.println("-------------------------------");
        System.out.printf("board %s is now deleted", boardToDelete.getName());
        System.out.println("-------------------------------");
        boardRepository.delete(boardToDelete);
    }

    @PostMapping("/{boardId}")
    public void update(@PathVariable String boardId, @ModelAttribute BoardDataDTO boardData) {
        Board boardToUpdate = boardRepository.findOne(Long.valueOf(boardId));
        System.out.println("-------------------------------");
        System.out.printf("board %s is now updated", boardToUpdate.getName());
        System.out.println("-------------------------------");
        boardToUpdate.setName(boardData.getName());
        boardToUpdate.setCategories(boardData.getCategories());
        boardToUpdate.setTags(boardData.getTags());
        boardRepository.save(boardToUpdate);
    }
}
