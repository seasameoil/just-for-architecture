package com.example.architecture.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1499319766L;

    public static final QMember member = new QMember("member1");

    public final com.example.architecture.model.entity.baseEntity.QBaseEntity _super = new com.example.architecture.model.entity.baseEntity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created_at = _super.created_at;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath memberName = createString("memberName");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final ListPath<String, StringPath> roles = this.<String, StringPath>createList("roles", String.class, StringPath.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated_at = _super.updated_at;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

