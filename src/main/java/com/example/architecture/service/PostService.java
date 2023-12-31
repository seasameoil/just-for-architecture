package com.example.architecture.service;

import com.example.architecture.model.entity.Post;
import com.example.architecture.model.request.PostRequest;
import com.example.architecture.model.response.PostResponse;
import com.example.architecture.repository.PostRepository;
import com.example.architecture.service.generic.BaseService;

public interface PostService extends BaseService<Post, PostRequest, PostResponse, PostRepository> {
}
