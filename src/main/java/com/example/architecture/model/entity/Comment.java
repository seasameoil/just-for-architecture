package com.example.architecture.model.entity;

import com.example.architecture.model.request.CommentRequest;
import com.example.architecture.model.response.CommentResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String content;
    private String nickName;

    @ManyToOne(fetch = FetchType.EAGER)
    Post post;

    public void update(CommentRequest commentRequest) {

        this.content = commentRequest.getContent();
        this.nickName = commentRequest.getNickName();
    }
}
