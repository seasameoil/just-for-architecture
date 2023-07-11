package com.example.architecture.model.entity;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comment")
public class Comment extends BaseEntity {

    private String content;
    private String nickName;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;
}
