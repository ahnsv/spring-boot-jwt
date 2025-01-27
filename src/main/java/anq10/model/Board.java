package anq10.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ElementCollection
    private List<String> categories;
    @ElementCollection
    private List<String> tags;

    @Builder
    public Board(String name, List<String> categories, List<String> tags) {
        this.name = name;
        this.categories = categories;
        this.tags = tags;
    }
}
