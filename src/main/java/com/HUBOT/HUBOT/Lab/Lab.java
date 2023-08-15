package com.HUBOT.HUBOT.Lab;

import com.HUBOT.HUBOT.Building.Building;
import com.HUBOT.HUBOT.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("labs")
public class Lab {

    @Id
    private String labId;
    @DBRef
    private Building building;
    @Indexed(unique = true)
    private int labLocationId;
    private Category category;
    private String keyword;
    private int labNumber;
    private int floor;
    @CreatedDate
    private LocalDateTime addedDate;
}
