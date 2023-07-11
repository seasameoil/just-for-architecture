package com.example.architecture.model.entity;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder @Table(name = "post")
public class Post extends BaseEntity {

    private String content;

    @ManyToOne
    private Member member;
}
