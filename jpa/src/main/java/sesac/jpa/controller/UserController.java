package sesac.jpa.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sesac.jpa.domain.UserEntity;
import sesac.jpa.dto.UserDTO;
import sesac.jpa.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // 홈 페이지
    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    // 로그인(selectOne)
    @PostMapping("/login/findOne")
    @ResponseBody
    public String postLogin(@RequestBody UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setPw(userDTO.getPw());
        userService.login(user);
        return ""; // 받은 return 값(유저 name)을 보내준다.
    }

    // 회원가입 페이지
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    // 회원가입(insert)
    @PostMapping("/register/insert")
    @ResponseBody
    public String postRegister(@RequestBody UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setPw(userDTO.getPw());
        user.setName(userDTO.getName());
        userService.insertUser(user);
        return "";
    }

    // 프로필 페이지
    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }


}
