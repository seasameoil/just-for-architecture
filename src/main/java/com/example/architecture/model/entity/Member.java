package com.example.architecture.model.entity;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import com.example.architecture.model.request.MemberRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "member")
public class Member extends BaseEntity {

    private String memberName;
    private String nickName;
    private String password;

    public void update(MemberRequest memberRequest) {

        this.memberName = memberRequest.getMemberName();
        this.nickName = memberRequest.getNickName();
        this.password = memberRequest.getPassword();
    }
}
