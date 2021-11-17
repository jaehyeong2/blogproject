package jaefactory.community.domain.category;


import jaefactory.community.domain.board.Board;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Board> boardList;
}
