package jaefactory.community.controller;


import jaefactory.community.domain.board.Board;
import jaefactory.community.dto.BoardDto;
import jaefactory.community.service.BoardService;
import jaefactory.community.service.CategoryService;
import jaefactory.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final UserService userService;
    private final BoardService boardService;
    private final CategoryService categoryService;

    @GetMapping({"/","index"})
    public String home(Model model) {
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("boards",boardService.getAllBoards());
        return "index";
    }

    @GetMapping("/board/add")
    public String addBoardGet(Model model){
        model.addAttribute("boards",boardService.getAllBoards());
//        model.addAttribute("boardDto",new BoardDto());
//        model.addAttribute("board",new Board());
//        model.addAttribute("categories",categoryService.getAllCategories());
        return "boardAdd";
    }

    @GetMapping("/board/detail/{id}")
    public String boardDetail(@PathVariable int id,Model model) {
        model.addAttribute("board",boardService.getBoardById(id));
        return "boardDetails";
    }

//    @PostMapping("/board/add")
//    public String addBoardPost(@ModelAttribute("board") BoardDto boardDto){
//
//        Board board = new Board();
//        board.setId(boardDto.getId());
//        board.setTitle(boardDto.getTitle());
//        board.setContent(boardDto.getContent());
//        board.setViewCount(boardDto.getViewCount());
//
//        board.setUser(userService.getUserById(boardDto.getUserId()).get());
//        board.setCategory(categoryService.getCategoryById(boardDto.getCategoryId()).get());
//
//        boardService.addBoard(board);
//        return "redirect:/board/add";
//    }
}
