package com.example.architecture.controller;

import com.example.architecture.model.network.Header;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController implements BaseController<MemberRequest, MemberResponse> {

    private final MemberService memberService;

    @Override
    @PostMapping("/create")
    public ResponseEntity create(@RequestPart(name = "data") MemberRequest request) {

        //System.out.println(request.getMemberName());
        MemberResponse response = memberService.create(request);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {

        MemberResponse memberResponse = memberService.read(id);
        return new ResponseEntity(memberResponse, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestPart(name = "data") MemberRequest request) {

        MemberResponse response = memberService.update(id, request);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        Long deletedId = memberService.delete(id);

        if(deletedId == 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(deletedId, HttpStatus.OK);
    }
}
