package com.example.architecture.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -764210525L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final com.example.architecture.model.entity.baseEntity.QBaseEntity _super = new com.example.architecture.model.entity.baseEntity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created_at = _super.created_at;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath nickName = createString("nickName");

    public final QPost post;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated_at = _super.updated_at;

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post"), inits.get("post")) : null;
    }

}

