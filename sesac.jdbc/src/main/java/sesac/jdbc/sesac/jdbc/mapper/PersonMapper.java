package sesac.jdbc.sesac.jdbc.mapper;

import org.apache.ibatis.annotations.*;
import sesac.jdbc.sesac.jdbc.domain.Person;

@Mapper
public interface PersonMapper {

    @Insert("INSERT INTO person(id,pw,name) VALUES(#{id}, #{pw}, #{name})")
    void insertPerson(Person person);

    @Select("SELECT * FROM person WHERE id=#{id} AND pw=#{pw} LIMIT 1")
    Person getPerson(String id, String pw);

    @Update("UPDATE person SET pw=#{pw}, name=#{name} WHERE id=#{id}")
    void updatePerson(Person person);

    @Delete("DELETE FROM person WHERE id=#{id}")
    void deletePerson(String id);
}
