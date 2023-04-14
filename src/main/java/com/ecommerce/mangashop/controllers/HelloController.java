package com.ecommerce.mangashop.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String hello() {
        return "hello world";
    }
}
