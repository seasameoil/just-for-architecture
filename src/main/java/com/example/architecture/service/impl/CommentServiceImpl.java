package com.example.architecture.service.impl;

import com.example.architecture.model.entity.Comment;
import com.example.architecture.model.request.CommentRequest;
import com.example.architecture.model.response.CommentResponse;
import com.example.architecture.repository.CommentRepository;
import com.example.architecture.service.CommentService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentRequest, CommentResponse, CommentRepository> implements CommentService {

    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
