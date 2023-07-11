package com.example.architecture.service;

import com.example.architecture.model.entity.Comment;
import com.example.architecture.repository.CommentRepository;
import com.example.architecture.service.generic.BaseService;
import org.springframework.stereotype.Service;

public interface CommentService extends BaseService<Comment, CommentRepository> {
}
