package com.example.architecture.service.impl;

import com.example.architecture.model.entity.Comment;
import com.example.architecture.model.entity.Member;
import com.example.architecture.model.entity.Post;
import com.example.architecture.model.request.CommentRequest;
import com.example.architecture.model.request.PostRequest;
import com.example.architecture.model.response.CommentResponse;
import com.example.architecture.model.response.PostResponse;
import com.example.architecture.repository.CommentRepository;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.repository.PostRepository;
import com.example.architecture.service.CommentService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentRequest, CommentResponse, CommentRepository> implements CommentService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }

    @Override
    public CommentResponse save(CommentRequest request) throws Exception {

        Optional<Post> optionalPost = postRepository.findById(request.getPostId());
        if (optionalPost.isEmpty()) {
            throw new Exception("Post not found");
        }

        Post post = optionalPost.get();

        System.out.println(request.getContent());
        Comment comment = modelMapper.map(request, Comment.class);
        comment.setPost(post);

        commentRepository.save(comment);

        return modelMapper.map(comment, CommentResponse.class);
    }
}
