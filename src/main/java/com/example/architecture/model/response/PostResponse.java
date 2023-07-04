package com.example.architecture.model.response;

import com.example.architecture.model.entity.Comment;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {

    private String nickName;
    private String content;

    private List<CommentResponse> comments;
}
