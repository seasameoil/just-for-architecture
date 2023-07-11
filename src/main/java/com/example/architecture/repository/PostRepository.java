package com.example.architecture.repository;

import com.example.architecture.model.entity.Post;
import com.example.architecture.repository.generic.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends BaseRepository<Post> {
}
