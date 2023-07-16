package com.example.architecture.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentRequest {

    private String content;
    private String nickName;
    private Long postId;
}
