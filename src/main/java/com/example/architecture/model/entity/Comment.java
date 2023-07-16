package com.example.architecture.model.entity;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import com.example.architecture.model.request.CommentRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    public void update(CommentRequest request) {
        this.content = request.getContent();
        this.nickName = request.getNickName();
    }
}
