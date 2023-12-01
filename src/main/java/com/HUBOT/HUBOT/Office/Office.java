package com.HUBOT.HUBOT.Office;

import com.HUBOT.HUBOT.Department.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("offices")
public class Office {

    @Id
    private String officeId;
    @Indexed(unique = true)
    private int office_location_id;
    @DBRef
    private Department department;
    private String officeNumber;
    private String keyword;
    private int floor;
}
