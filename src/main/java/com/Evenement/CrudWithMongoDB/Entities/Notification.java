package com.Evenement.CrudWithMongoDB.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
@ToString
public class Notification {

    @Id
    private String id;
    @DBRef
    private Guest guest;
    private String eventName;
    private LocalDateTime sendAt;
    private Boolean sent;
}
