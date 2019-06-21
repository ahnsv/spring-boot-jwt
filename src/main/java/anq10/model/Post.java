package anq10.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long pid;
    private String author;
    private String content;

    @Temporal(TemporalType.TIME)
    private Date createDate;

    @Temporal(TemporalType.TIME)
    private Date modDate;
}
