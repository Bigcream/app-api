package com.example.appapi.model.entity;


import com.example.appapi.model.dto.UserDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "user")
public class User {

    @Id
    protected Long id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;

    public UserDTO convertToDTO(){
        return UserDTO.builder()
                .email(this.getEmail())
                .id(getId())
                .build();
    }

}
