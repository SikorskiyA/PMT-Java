package com.example.pmtjava;

import org.springframework.web.bind.annotation.RequestMapping;

public class taskController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
