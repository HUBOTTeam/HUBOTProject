package com.HUBOT.HUBOT.WorkingEmployee;

import com.HUBOT.HUBOT.WorkingDepartment.WorkingDepartment;
import com.HUBOT.HUBOT.WorkingOffice.WorkingOffice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("WorkingEmployees")
public class WorkingEmployee {
    @Id
    private String workingEmployeesID;
    @DBRef
    private WorkingOffice workingOffice;
    @DBRef
    private WorkingDepartment workingDepartment;
    private String workingEmployeeFirstName;
    private String workingEmployeeLastName;
}
