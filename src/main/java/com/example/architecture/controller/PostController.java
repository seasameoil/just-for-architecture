package com.example.architecture.controller;

import com.example.architecture.model.request.PostRequest;
import com.example.architecture.model.response.PostResponse;
import com.example.architecture.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController implements BaseController<PostRequest, PostResponse> {

    private final PostService postService;

    @Override
    @PostMapping("/create")
    public ResponseEntity create(@RequestPart(name = "data") PostRequest postRequest) {

        PostResponse response = postService.create(postRequest);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {

        PostResponse response = postService.read(id);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestPart(name = "data") PostRequest postRequest) {

        PostResponse response = postService.update(id, postRequest);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        Long deletedId = postService.delete(id);

        if(deletedId == 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(deletedId, HttpStatus.OK);
    }
}
