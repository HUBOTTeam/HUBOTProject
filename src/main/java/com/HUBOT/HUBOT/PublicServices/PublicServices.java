package com.HUBOT.HUBOT.PublicServices;

import com.HUBOT.HUBOT.Enum.TypeOfService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("publicServices")
public class PublicServices {
    @Id
    private String publicServicesId;
    @Indexed(unique = true)
    private int publicServiceLocationId;
    @DBRef
    private String buildingId;
    private TypeOfService typeOfService;
    private String publicServicePlaceName;
    private String keyword;
    private String description;
}
