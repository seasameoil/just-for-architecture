package com.example.architecture.controller.impl;

import com.example.architecture.controller.PostController;
import com.example.architecture.controller.generic.impl.BaseControllerImpl;
import com.example.architecture.model.entity.Post;
import com.example.architecture.repository.PostRepository;
import com.example.architecture.service.generic.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostControllerImpl extends BaseControllerImpl<Post, PostRepository> implements PostController {

    public PostControllerImpl(BaseService<Post, PostRepository> baseService) {
        super(baseService);
    }
}
