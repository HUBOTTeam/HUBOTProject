package com.HUBOT.HUBOT.Hall;

import com.HUBOT.HUBOT.Building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("halls")
public class Hall {
    @Id
    private String hallId;
    @DBRef
    private Building building;
    private String hallName;
    private int capacity;
    private int floor;
    private String keyword;
    @CreatedDate
    private LocalDateTime addedDate;

}
