package jaefactory.community.service;


import jaefactory.community.domain.board.Board;
import jaefactory.community.domain.board.BoardRepository;
import jaefactory.community.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

    @Transactional
    public void addBoard(Board board, User user) {
        board.setViewCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoardById(long id){
        boardRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Board> getBoardById(long id){
        return boardRepository.findById(id);
    }
}
