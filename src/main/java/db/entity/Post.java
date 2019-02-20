package db.entity;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Post {
    private Long id;
    private int jobCode;
    private String postName;

    public Post(){

    }
}
