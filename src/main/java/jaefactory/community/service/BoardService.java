package jaefactory.community.service;


import jaefactory.community.domain.board.Board;
import jaefactory.community.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

    @Transactional
    public void addBoard(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoardById(long id){
        boardRepository.deleteById(id);
    }


}
