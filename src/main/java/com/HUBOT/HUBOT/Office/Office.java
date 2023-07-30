package com.HUBOT.HUBOT.Office;

import com.HUBOT.HUBOT.Department.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("offices")
public class Office {

    @Id
    private String office_id;
    private String keyword;
    private int floor;
    private int office_location_id;
    @DBRef
    private Department department;

    @Override
    public String toString() {
        return "Office{" +
                "office_id='" + office_id + '\'' +
                ", keyword='" + keyword + '\'' +
                ", floor=" + floor +
                ", office_location_id=" + office_location_id +
                ", department=" + department +
                '}';
    }
}
