package com.example.architecture.interfaces;

public interface CrudInterface<Request, Response> {

    Response create(Request request);
    Response read(Long id);
    Response update(Long id, Request request);
    Long delete(Long id);
}
