package com.example.architecture.ifs;

import com.example.architecture.model.network.Header;

public interface CrudInterface<Request, Response> {

    Response create(Request request);
    Response read(Long id);
    Response update(Long id, Request request);
    Long delete(Long id);
}
