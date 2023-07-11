package com.example.architecture.service.impl;

import com.example.architecture.model.entity.Post;
import com.example.architecture.repository.PostRepository;
import com.example.architecture.service.PostService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends BaseServiceImpl<Post, PostRepository> implements PostService {

    public PostServiceImpl(PostRepository repository) {
        super(repository);
    }
}
