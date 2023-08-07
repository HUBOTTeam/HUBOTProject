package com.HUBOT.HUBOT.Notes;

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
@Document("notes")
public class Note {
    @Id
    private String noteId;
    @Indexed(unique = true)
    private String noteTitle;
    private String note;
//    @DBRef
//    private

}
