package com.example.architecture.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostRequest {

    private String content;
    private Long memberId;
}
