package anq10.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDataDTO {
    private String pid;
    private String author;
    private String content;

    @Builder
    public PostDataDTO(String pid, String author, String content) {
        this.pid = pid;
        this.author = author;
        this.content = content;
    }
}
