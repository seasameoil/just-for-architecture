package com.example.architecture.model.request;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequest {

    private String memberName;
    private String nickName;
    private String password;
}
