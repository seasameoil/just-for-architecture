package com.example.architecture.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponse {

    private String memberName;
    private String nickName;
}
