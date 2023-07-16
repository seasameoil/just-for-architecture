package com.example.architecture.controller.impl;

import com.example.architecture.controller.CommentController;
import com.example.architecture.controller.generic.BaseController;
import com.example.architecture.controller.generic.impl.BaseControllerImpl;
import com.example.architecture.model.entity.Comment;
import com.example.architecture.model.request.CommentRequest;
import com.example.architecture.model.response.CommentResponse;
import com.example.architecture.repository.CommentRepository;
import com.example.architecture.service.generic.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentControllerImpl extends BaseControllerImpl<Comment, CommentRequest, CommentResponse, CommentRepository> implements CommentController {

    public CommentControllerImpl(BaseService<Comment, CommentRequest, CommentResponse, CommentRepository> baseService) {
        super(baseService);
    }
}
