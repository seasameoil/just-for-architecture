package com.example.architecture.service.impl;

import com.example.architecture.model.entity.Member;
import com.example.architecture.model.entity.Post;
import com.example.architecture.model.request.PostRequest;
import com.example.architecture.model.response.PostResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.repository.PostRepository;
import com.example.architecture.service.PostService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl extends BaseServiceImpl<Post, PostRequest, PostResponse, PostRepository> implements PostService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ModelMapper modelMapper;

    public PostServiceImpl(PostRepository repository) {
        super(repository);
    }

    @Override
    public PostResponse save(PostRequest request) throws Exception {

        Optional<Member> optionalMember = memberRepository.findById(request.getMemberId());
        if (optionalMember.isEmpty()) {
            throw new Exception("Member not found");
        }

        Member member = optionalMember.get();

        System.out.println(request.getContent());
        Post post = modelMapper.map(request, Post.class);
        post.setMember(member);

        postRepository.save(post);

        return modelMapper.map(post, PostResponse.class);
    }
}
