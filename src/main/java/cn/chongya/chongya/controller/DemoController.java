package cn.chongya.chongya.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test")
    public String test() {
        return "123";
    }



    @PostMapping("/getUserName")
    public String getUserName() {
        return "ashuai";
    }
}
