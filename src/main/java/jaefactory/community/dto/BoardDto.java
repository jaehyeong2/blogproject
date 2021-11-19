package jaefactory.community.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardDto {
    private Long id;

    private String title;
    private String content;
    private String category;

    private int viewCount;

    private long userId;
    private long categoryId;
}
