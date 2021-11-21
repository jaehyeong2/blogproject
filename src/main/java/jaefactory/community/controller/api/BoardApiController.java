package jaefactory.community.controller.api;

import jaefactory.community.config.auth.PrincipalDetails;
import jaefactory.community.domain.board.Board;
import jaefactory.community.dto.BoardDto;
import jaefactory.community.dto.CommonResDto;
import jaefactory.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public BoardDto<?> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetails principal){
        boardService.addBoard(board,principal.getUser());
        return new BoardDto<Integer>(1,1);
    }

    @DeleteMapping("/api/board/(id)")
    public BoardDto<?> delete(@PathVariable int id){
        boardService.deleteBoardById(id);
        return new BoardDto<Integer>(1,1);
    }

    @PutMapping("/api/board/{id}")
    public BoardDto<?> update(@PathVariable int id,@RequestBody Board board){
        boardService.updateBoardById(id,board);
        return new BoardDto<Integer>(1,-1);
    }
}
