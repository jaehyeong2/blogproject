package jaefactory.community.service;


import jaefactory.community.domain.reply.Reply;
import jaefactory.community.domain.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;


    @Transactional(readOnly = true)
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    @Transactional
    public void addReply(Reply reply){
        replyRepository.save(reply);
    }

    @Transactional
    public void deleteReplyById(long id){
        replyRepository.deleteById(id);
    }
}
