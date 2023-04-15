package sesac.jdbc.sesac.jdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.jdbc.sesac.jdbc.domain.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByName(String name);    // SELECT ~~ WHERE name = #{name}
//    Optional<UserEntity> findById(int id); // SELECT ~~ WHERE id = #{id}
//    Optional<UserEntity> findByIdName(int id, String name); // SELECT ~~ WHERE id = #{id} AND name= #{name}
    // findBy뒤에 대문자로 오는 컬럼을 기준으로 불러온다. (jpa 기능)


    // UserEntity userEntity
    // Optional<UserEntity> user; user.get()
    // null 일 수도 있는 객체를 담는 클래스

}
