package sesac.jdbc.sesac.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sesac.jdbc.sesac.jdbc.domain.User;
import sesac.jdbc.sesac.jdbc.domain.UserEntity;
import sesac.jdbc.sesac.jdbc.dto.UserDTO;
import sesac.jdbc.sesac.jdbc.service.MainService;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    // mybatis & jpa
    @GetMapping("/users")
    public String getUsers(Model model) {
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getUserList();
        model.addAttribute("list", userList);
        return "user";
    }

    // mybatis
//    @GetMapping("/user/insert")
//    public String getInsertUser(@RequestParam String name, @RequestParam String nickname, Model model) {
//        User user = new User();
//        user.setName(name);
//        user.setNickname(nickname);
//
//        mainService.addUser(user);
//
//        model.addAttribute("list", null);
//        return "user";
//    }

    // jpa
    @GetMapping("/user/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String nickname, Model model) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setNickname(nickname);

        mainService.addUser(user);

        model.addAttribute("list", null);
        return "user";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam String name, Model model) {
        ArrayList<UserDTO> userList = mainService.getUserName(name);

        model.addAttribute("list", userList);
        return "user";
    }

}
