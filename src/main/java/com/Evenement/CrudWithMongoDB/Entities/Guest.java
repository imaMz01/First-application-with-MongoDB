package com.Evenement.CrudWithMongoDB.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Guest {

    @Id
    private String id;
    private String name;
    private String email;
    private String tel;
    @DBRef
    private List<Event> events = new ArrayList<>();
}
