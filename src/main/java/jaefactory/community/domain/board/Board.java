package jaefactory.community.domain.board;


import jaefactory.community.domain.category.Category;
import jaefactory.community.domain.reply.Reply;
import jaefactory.community.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "board_id")
    private Long id;

    private String title;

    @Lob //용량 큰 데이터
    private String content;
    
    private int viewCount; //조회수
    private LocalDateTime createDate;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

//    @JoinColumn(name = "category_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Category category;

    @OneToMany(mappedBy = "board")
    private List<Reply> replies = new ArrayList<>();

    @PrePersist
    public void createDate() { this.createDate = LocalDateTime.now();}
}
