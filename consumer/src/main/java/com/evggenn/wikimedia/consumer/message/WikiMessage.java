package com.evggenn.wikimedia.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WikiMessage {

    @Id
    private String id;
    private String type;
    private String title;
    private String user;
    private long timestamp;
    private String comment;

}
