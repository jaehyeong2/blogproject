package jaefactory.community.domain.user;

import jaefactory.community.domain.board.Board;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String username;//아이디

    @Column(nullable = false)
    private String realName; //이름

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String role;  //USER,ADMIN

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList;

    @PrePersist
    public void createDate() { this.createDate = LocalDateTime.now();}

}
