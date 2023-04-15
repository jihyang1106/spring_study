package sesac.spring.api.sesac.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sesac.spring.api.sesac.api.dto.UserDTO;
import sesac.spring.api.sesac.api.vo.UserVO;

@Controller
public class AxiosController {

    // DTO - axios
    // formdata형식이면 requestbody가 없어도 잘 보내지지만
    // axios 전송 일때는requestbody가 있어야지만 데이터 전송 가능
    @GetMapping("/axios")
    public String axiosAPI () {
        return "axios";
    }
    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosAPI1(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
        String msg = "이름 : " + name + "\n나이 " + age;
        return msg;
    }

    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosAPI2(UserDTO userDTO) {
        String msg = "이름 : " + userDTO.getName() + "\n 나이 " + userDTO.getAge();
        return msg;
    }

    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosAPI3(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
        String msg = "이름 : " + name + "\n나이 " + age;
        return msg;
    }

    @PostMapping ("/axios/response4")
    @ResponseBody
    public String axiosAPI4(UserDTO userDTO) {
        String msg = "이름 : " + userDTO.getName() + "\n 나이 " + userDTO.getAge();
        return msg;
    }

    @PostMapping ("/axios/response5")
    @ResponseBody
    public String axiosAPI5(@RequestBody UserDTO userDTO) {
        String msg = "이름 : " + userDTO.getName() + "\n 나이 " + userDTO.getAge();
        return msg;
    }

    // VO - axios
    @GetMapping("/axios/vo/response1")
    @ResponseBody
    public String axiosvoAPI1(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
        String msg = "이름 : " + name + "\n나이 " + age;
        return msg;
    }

    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosvoAPI2(UserVO userVO) {
        String msg = "이름 : " + userVO.getName() + "\n 나이 " + userVO.getAge();
        return msg;
    }

    @PostMapping ("/axios/vo/response3")
    @ResponseBody
    public String axiosvoAPI3(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
        String msg = "이름 : " + name + "\n나이 " + age;
        return msg;
    }

    @PostMapping ("/axios/vo/response4")
    @ResponseBody
    public String axiosvoAPI4(UserVO userVO) {
        String msg = "이름 : " + userVO.getName() + "\n 나이 " + userVO.getAge();
        return msg;  // NULL 값
    }

    @PostMapping ("/axios/vo/response5")
    @ResponseBody
    public String axiosvoAPI5(@RequestBody UserVO userVO) {
        String msg = "이름 : " + userVO.getName() + "\n 나이 " + userVO.getAge();
        return msg; // @RequestBody가 setter의 역할 대신 해줌
    }

}
