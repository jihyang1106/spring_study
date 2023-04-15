package sesac.jdbc.sesac.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.jdbc.sesac.jdbc.domain.Person;
import sesac.jdbc.sesac.jdbc.dto.PersonDTO;
import sesac.jdbc.sesac.jdbc.service.PersonService;

@Controller
// @RestController => PersonController 안에 있는 모든 함수들이 @ResponseBody 붙인 것과 동일
@RequestMapping("/person") // 기본 baseURL으로
public class PersonController {

    @Autowired
    PersonService personService;
    @GetMapping ("/register") // @GetMapping("/person/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")  // @PostMapping("/person/register")
    @ResponseBody
    public String postRegister(@RequestBody PersonDTO personDTO) {
        personService.insertPerson(personDTO);
        return "";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestBody PersonDTO personDTO) {
        PersonDTO person = personService.getPerson(personDTO);
        if(person == null) return false;
        else return true;
    }

    @PostMapping("/info")
    public String postInfo(PersonDTO personDTO, Model model) { // 일반 폼 전송이니까 @RequestBody 필요 x
        PersonDTO person = personService.getPerson(personDTO);
        model.addAttribute("person", person);
        return "info";
    }

    @PostMapping("/info/edit")
    @ResponseBody
    public String postInfoEdit(@RequestBody PersonDTO personDTO) {
        personService.updatePerson(personDTO);
        return "";
    }

    @PostMapping("/info/delete")
    @ResponseBody
    public String postInfoDelete(@RequestBody PersonDTO personDTO) {
        personService.deletePerson(personDTO);
        return "";
    }
}
