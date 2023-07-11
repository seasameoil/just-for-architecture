package com.example.architecture.repository;

import com.example.architecture.model.entity.Comment;
import com.example.architecture.repository.generic.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends BaseRepository<Comment> {
}
