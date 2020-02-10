package com.ds.test.controller;

import com.ds.test.repository.SubCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubCommentController {

    @Autowired
    private SubCommentRepository subCommentRepository;

}
