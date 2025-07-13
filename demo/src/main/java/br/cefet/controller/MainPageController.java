package br.cefet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
