package anq10.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDataDTO {
    private String name;
    private List<String> categories;
    private List<String> tags;

    @Builder
    public BoardDataDTO(String name, List<String> categories, List<String> tags) {
        this.name = name;
        this.categories = categories;
        this.tags = tags;
    }
}
