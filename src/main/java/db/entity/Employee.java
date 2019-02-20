package db.entity;

import lombok.*;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String lastName;
    private String thirdName;
    private int experience;
    private Sex sex;
    private Date dateOfBirthday;
    private String address;
    private Long telephone;
    private String email;
    private Post post;
    private Department department;
}
