package com.example.architecture.controller;

import com.example.architecture.model.network.Header;
import com.example.architecture.model.response.MemberResponse;
import org.springframework.http.ResponseEntity;

public interface BaseController<Request, Response> {

    ResponseEntity create(Request request);
    ResponseEntity read(Long id);
    ResponseEntity update(Long id, Request request);
    ResponseEntity delete(Long id);
}
