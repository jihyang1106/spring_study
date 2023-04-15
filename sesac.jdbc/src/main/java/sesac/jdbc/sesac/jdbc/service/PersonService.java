package sesac.jdbc.sesac.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.jdbc.sesac.jdbc.domain.Person;
import sesac.jdbc.sesac.jdbc.dto.PersonDTO;
import sesac.jdbc.sesac.jdbc.mapper.PersonMapper;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;
    // 회원가입
    public void insertPerson(PersonDTO personDTO) {
        Person person = new Person(); // 객체 생성
        person.setId(personDTO.getId());
        person.setPw(personDTO.getPw());
        person.setName(personDTO.getName());
        personMapper.insertPerson(person);
    }

    public PersonDTO getPerson(PersonDTO personDTO) {
        Person person = personMapper.getPerson(personDTO.getId(), personDTO.getPw());

        if(person == null) return null;
        PersonDTO info = new PersonDTO();
        info.setId(person.getId());
        info.setPw(person.getPw());
        info.setName(person.getName());
        info.setNickname(person.getId() + person.getName());
        return info;
    }

    public void updatePerson(PersonDTO personDTO) {
        System.out.println(personDTO.getId());
        System.out.println(personDTO.getPw());
        System.out.println(personDTO.getName());
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setPw(personDTO.getPw());
        person.setName(personDTO.getName());
        personMapper.updatePerson(person);
    }

    public void deletePerson(PersonDTO personDTO) {
        personMapper.deletePerson(personDTO.getId());
    }
}
