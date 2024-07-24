package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "订单")
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @GetMapping
    public void hello(){

    }
}
