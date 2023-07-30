package com.HUBOT.HUBOT.PublicServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("publicServices")
public class publicServices {
    @Id
    private String publicServicesId;
}
