package com.example.architecture.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    Member member;
}
