package com.example.appapi.model.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Gallery {
    private Integer id;
    private List<Object> images;
}
