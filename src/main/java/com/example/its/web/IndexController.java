package com.example.its.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping("/")
    //@ResponseBody 戻り値が直接レスポンスに記述される
    public String index(){
        return "index";
    }
}
