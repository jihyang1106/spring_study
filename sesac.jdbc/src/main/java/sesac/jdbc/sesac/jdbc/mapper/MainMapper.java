package sesac.jdbc.sesac.jdbc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sesac.jdbc.sesac.jdbc.domain.User;

import java.util.List;

@Mapper
public interface MainMapper {

    // MainMapper.xml 참고하기
    List<User> retrieveAll(); // MainMapper.xml을 참고하는 작업

    // MainMapper.xml 참고 안 하기
    // insertUser를 실행할 때 @Insert sql문을 실행한다.
    // @Insert 는 mybatis Annotation으로 sql이 insert문이라는 것을 나타냄
    @Insert("insert into user(name, nickname) values(#{name}, #{nickname})")
    void insertUser(User user);
}
