package com.example.architecture.service;

import com.example.architecture.interfaces.CrudInterface;
import com.example.architecture.model.entity.Comment;
import com.example.architecture.model.entity.Post;
import com.example.architecture.model.request.CommentRequest;
import com.example.architecture.model.response.CommentResponse;
import com.example.architecture.model.response.PostResponse;
import com.example.architecture.repository.CommentRepository;
import com.example.architecture.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService implements CrudInterface<CommentRequest, CommentResponse> {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public CommentResponse create(CommentRequest commentRequest) {

        Comment comment = Comment.builder()
                .content(commentRequest.getContent())
                .nickName(commentRequest.getNickName())
                .post(postRepository.findById(commentRequest.getPostId()).get())
                .build();

        CommentResponse commentResponse = buildCommentResponse(commentRepository.save(comment));

        return commentResponse;
    }

    @Override
    public CommentResponse read(Long id) {

        Comment comment = commentRepository.findById(id).get();

        CommentResponse commentResponse = buildCommentResponse(comment);

        return commentResponse;
    }

    @Override
    @Transactional
    public CommentResponse update(Long id, CommentRequest commentRequest) {

        Comment comment = commentRepository.findById(id).get();

        comment.setContent(comment.getContent());
        comment.setNickName(comment.getNickName());

        CommentResponse commentResponse = buildCommentResponse(commentRepository.save(comment));

        return commentResponse;
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        try {
            commentRepository.deleteById(id);
            return id;
        } catch (Exception e) {
            return 0l;
        }
    }

    // <------------- commentResponse 빌드 ------------>
    private CommentResponse buildCommentResponse(Comment comment) {

        CommentResponse commentResponse = CommentResponse.builder()
                .nickName(comment.getNickName())
                .content(comment.getContent())
                .build();

        return commentResponse;
    }
}
