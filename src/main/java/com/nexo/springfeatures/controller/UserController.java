package com.nexo.springfeatures.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/1.0.0/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/")
    public Response getResponse(){
        Response response = new Response();
        response.setStudents(studentRepository.findAll());
        response.setColleges(collegeRepository.findAll());
        return response;
    }


}
