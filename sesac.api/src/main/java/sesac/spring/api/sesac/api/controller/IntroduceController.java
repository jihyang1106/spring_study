package sesac.spring.api.sesac.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IntroduceController {

    @GetMapping("/introduce")
    public String getIntro() {
        return "introduce";
    }

    @GetMapping("/introduce/{name}")
    public String getIntro1(@PathVariable(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "introduce";
    }

    @GetMapping("/introduce2")
    public String getIntro2(@RequestParam String name, @RequestParam int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "introduce";
    }

    @PostMapping("/axios/postInsert")
    public String postInsert(@RequestParam(value))


}
