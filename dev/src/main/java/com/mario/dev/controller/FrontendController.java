package com.mario.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    @RequestMapping(value = { "/", "/{[path:[^\\.]*}" })
    public String index() {
        return "forward:/index.html";
    }
}

