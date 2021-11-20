package jaefactory.community.controller.api;

import jaefactory.community.config.auth.PrincipalDetails;
import jaefactory.community.domain.board.Board;
import jaefactory.community.dto.BoardDto;
import jaefactory.community.dto.CommonResDto;
import jaefactory.community.service.BoardService;
import jaefactory.community.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final CategoryService categoryService;

    @PostMapping("/api/board")
    public BoardDto<?> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetails principal){
//        board.setCategory(categoryService.getCategoryById(board.getId()));
        boardService.addBoard(board,principal.getUser());
        return new BoardDto<Integer>(1,1);
    }

//    @PostMapping("/board/add")
//    public String addBoardPost(@ModelAttribute("board") BoardDto boardDto,@AuthenticationPrincipal PrincipalDetails principal){
//
//        Board board = new Board();
//        board.setId(boardDto.getId());
//        board.setTitle(boardDto.getTitle());
//        board.setContent(boardDto.getContent());
//        board.setViewCount(boardDto.getViewCount());
//
//        board.setCategory(categoryService.getCategoryById(boardDto.getCategoryId()).get());
//
////        boardService.addBoard(board);
//        return "redirect:/board/add";
//    }
}
