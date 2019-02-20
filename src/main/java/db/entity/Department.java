package db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Department {

    private Long id;
    private int departmentCode;
    private String departmentName;

    public Department() {

    }
}
