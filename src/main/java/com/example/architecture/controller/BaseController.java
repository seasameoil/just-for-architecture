package com.example.architecture.controller;

import org.springframework.http.ResponseEntity;

public interface BaseController<Request, Response> {

    ResponseEntity create(Request request);
    ResponseEntity read(Long id);
    ResponseEntity update(Long id, Request request);
    ResponseEntity delete(Long id);
}
