package com.example.architecture.controller;

import com.example.architecture.model.request.CommentRequest;
import com.example.architecture.model.response.CommentResponse;
import com.example.architecture.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController implements BaseController<CommentRequest, CommentResponse> {

    private final CommentService commentService;

    @Override
    @PostMapping("/create")
    public ResponseEntity create(@RequestPart(name = "data") CommentRequest commentRequest) {

        CommentResponse commentResponse = commentService.create(commentRequest);

        return new ResponseEntity(commentResponse, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {

        CommentResponse commentResponse = commentService.read(id);

        return new ResponseEntity(commentResponse, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestPart(name = "data") CommentRequest commentRequest) {

        CommentResponse commentResponse = commentService.update(id, commentRequest);

        return new ResponseEntity(commentResponse, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        Long deletedId = commentService.delete(id);

        if(deletedId == 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(deletedId, HttpStatus.OK);
    }
}
