package com.example.architecture.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {

    private String content;
    private String nickName;
    private Long postId;
}
