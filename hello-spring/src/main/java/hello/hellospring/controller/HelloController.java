package hello.hellospring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("data", "HELLO WORLD");
        return "index";
    }

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "안녕하세요! HELLO!");
        return "hello";
    }
}
