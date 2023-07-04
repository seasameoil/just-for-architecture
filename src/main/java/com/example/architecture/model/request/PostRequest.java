package com.example.architecture.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {

    private Long memberId;
    private String content;
}
