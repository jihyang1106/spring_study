package sesac.spring.api.sesac.api.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.spring.api.sesac.api.dto.UserDTO;
import sesac.spring.api.sesac.api.vo.UserVO;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "request";
    }

    @GetMapping("/get/response1")
    // @RequestParam("name") String name2 : input name name인 것을 변수 name2에 담는다.
    // @RequestParam String name : input name name
    public String getAPI1(@RequestParam("name") String name2, Model model) {
        model.addAttribute("name", name2);
        return "response";
    }

    @GetMapping("/get/response2")
    // false는 값이 들어갈 수도 안들어갈 수도 있음
    public String getAPI2(@RequestParam(value = "name", required = false) String name2, Model model) {
        model.addAttribute("name", name2);
        return "response";
    }

    // 값이 하나던 2개던(name만 있던 age만 있던 실행시켜라)
    @GetMapping ({"/get/response3/{name}/{age}", "/get/response3/{name}"})
    // input에서의 name이 다르면 변수 지정
    public String getAPI3(@PathVariable String name, @PathVariable(value = "age", required = false) String abc, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }


    @PostMapping("/post/response1")
    public String postAPI1(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }
    @PostMapping("/post/response2")
    public String postAPI2(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/response3")
    @ResponseBody // res.send() 파일을 렌더 하는 게 아닌 값을 전달
    public String postAPI3(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "이름은 : " + name;
    }


}
