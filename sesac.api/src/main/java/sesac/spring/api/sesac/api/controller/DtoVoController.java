package sesac.spring.api.sesac.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sesac.spring.api.sesac.api.dto.UserDTO;
import sesac.spring.api.sesac.api.vo.UserVO;

@Controller
public class DtoVoController {


    @GetMapping("/dto")
    public String dto (){
        return "dto";
    }

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoAPI1(UserDTO userDTO) {
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!!";
        return msg;
    }

    @PostMapping("/dto/response2")
    @ResponseBody
    public String dtoAPI2(UserDTO userDTO) {
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!!";
        return msg;
    }

    // 일반 폼 전송 할 때는 RequestBody 사용 불가
    @PostMapping ("/dto/response3")
    @ResponseBody
    public String dtoAPI3(@RequestBody UserDTO userDTO) {
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!!";
        return msg;
    }

    @GetMapping("/vo")
    public String getVo() {
        return "vo";
    }

    @GetMapping("/vo/response1")
    @ResponseBody
    public String voAPI1(UserVO userVO) {
        String msg = userVO.getName() + " " + userVO.getAge() + "!!!";
        return msg;
    }

    @PostMapping ("/vo/response2")
    @ResponseBody
    public String voAPI2(UserVO userVO) {
        String msg = userVO.getName() + " " + userVO.getAge() + "!!!!";
        return msg;
    }

    @PostMapping ("/vo/response3")
    @ResponseBody
    public String voAPI3(@RequestBody UserVO userVO) {
        String msg = userVO.getName() + " " + userVO.getAge() + "!!!!";
        return msg;
    }
}
