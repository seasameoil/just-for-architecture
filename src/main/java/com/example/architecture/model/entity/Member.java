package com.example.architecture.model.entity;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
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
}
