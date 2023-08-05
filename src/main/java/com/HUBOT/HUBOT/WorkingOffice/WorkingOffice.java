package com.HUBOT.HUBOT.WorkingOffice;

import com.HUBOT.HUBOT.WorkingDepartment.WorkingDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("WorkingOffice")
public class WorkingOffice {
    @Id
    private String workingOfficeId;
    @DBRef
    private WorkingDepartment workingDepartment;
    private String keyword;
    private int workingOfficeLocationId;
    private int floor;

}
