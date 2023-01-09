package com.example.appapi.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Document(collection = "role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    private String id;
    private String name;
}
