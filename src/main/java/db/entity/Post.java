package db.entity;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Post {
    private int jobCode;
    private String postName;
    private double salary;

    public Post(){

    }
}
