package com.example.architecture.service;

import com.example.architecture.interfaces.CrudInterface;
import com.example.architecture.model.entity.Member;
import com.example.architecture.model.entity.Post;
import com.example.architecture.model.request.PostRequest;
import com.example.architecture.model.response.PostResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService implements CrudInterface<PostRequest, PostResponse> {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public PostResponse create(PostRequest postRequest) {

        Post post = Post.builder()
                .content(postRequest.getContent())
                .member(memberRepository.findById(postRequest.getMemberId()).get())
                .build();

        Post newPost = postRepository.save(post);

        PostResponse postResponse = buildPostResponse(newPost);

        return postResponse;
    }

    @Override
    public PostResponse read(Long id) {

        Post post = postRepository.findById(id).get();

        PostResponse postResponse = buildPostResponse(post);

        return postResponse;
    }

    @Override
    @Transactional
    public PostResponse update(Long id, PostRequest postRequest) {

        Post post = postRepository.findById(id).get();

        post.setContent(postRequest.getContent());

        Post changedPost = postRepository.save(post);

        PostResponse postResponse = buildPostResponse(changedPost);

        return postResponse;
    }

    @Override
    @Transactional
    public Long delete(Long id) {

        try {
            postRepository.deleteById(id);
            return id;
        } catch (Exception e) {
            return 0l;
        }
    }

    // <------------- postResponse 빌드 ------------>
    private PostResponse buildPostResponse(Post post) {

        String nickName = post.getMember().getNickName();

        PostResponse postResponse = PostResponse.builder()
                .nickName(nickName)
                .content(post.getContent())
                .build();

        return postResponse;
    }
}
