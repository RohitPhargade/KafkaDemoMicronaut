package com.example.controller;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @Get(value = "/api")
    public String testingApi(){
        return "Api is working: current timestamp is :"+ LocalDateTime.now();
    }

}
