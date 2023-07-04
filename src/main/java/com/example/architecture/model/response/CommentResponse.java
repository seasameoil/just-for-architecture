package com.example.architecture.model.response;

import com.example.architecture.model.entity.Comment;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {

    private String content;
    private String nickName;

    @Builder
    public CommentResponse build(Comment comment) {
        this.content = comment.getContent();
        this.nickName = comment.getNickName();

        return this;
    }
}
