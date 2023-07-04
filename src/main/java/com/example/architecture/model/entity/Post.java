package com.example.architecture.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    Member member;

    /*@OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;*/
}
