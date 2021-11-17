package jaefactory.community.domain.board;


import jaefactory.community.domain.category.Category;
import jaefactory.community.domain.reply.Reply;
import jaefactory.community.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "board_id")
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Lob //용량 큰 데이터
    private String content;
    
    private int viewCount; //조회수

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "board")
    private List<Reply> replies;
}
