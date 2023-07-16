package com.example.architecture.service;

import com.example.architecture.model.entity.Comment;
import com.example.architecture.model.request.CommentRequest;
import com.example.architecture.model.response.CommentResponse;
import com.example.architecture.repository.CommentRepository;
import com.example.architecture.service.generic.BaseService;

public interface CommentService extends BaseService<Comment, CommentRequest, CommentResponse, CommentRepository> {
}
