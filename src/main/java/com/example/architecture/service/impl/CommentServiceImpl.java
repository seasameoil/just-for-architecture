package com.example.architecture.service.impl;

import com.example.architecture.model.entity.Comment;
import com.example.architecture.repository.CommentRepository;
import com.example.architecture.service.CommentService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentRepository> implements CommentService {

    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
