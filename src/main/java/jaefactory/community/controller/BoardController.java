package jaefactory.community.controller;


import jaefactory.community.config.auth.PrincipalDetails;
import jaefactory.community.service.BoardService;
import jaefactory.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final UserService userService;
    private final BoardService boardService;

    @GetMapping({"/","index"})
    public String home(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("boards",boardService.getAllBoards());
        model.addAttribute("user",principalDetails);
        return "index";
    }

    @GetMapping("/board/add")
    public String addBoardGet(Model model){
        model.addAttribute("boards",boardService.getAllBoards());
//        board.setCategory(categoryService.getCategoryById(boardDto.getCategoryId()).get());
//        model.addAttribute("boardDto",new BoardDto());
//        model.addAttribute("board",new Board());
        return "boardSave";
    }

    @GetMapping("/board/detail/{id}")
    public String boardDetail(@PathVariable int id,Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("board",boardService.getBoardById(id));
        model.addAttribute("user",principalDetails);

        return "boardDetails";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.getBoardById(id));
        return "boardUpdate";
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
