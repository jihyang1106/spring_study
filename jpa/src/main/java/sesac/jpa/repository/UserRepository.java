package sesac.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesac.jpa.domain.UserEntity;
import sesac.jpa.dto.UserDTO;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // 아이디랑 패스워드를 기준으로 로그인 여부 확인
    Optional<UserEntity> findByIdPw(UserEntity user);

}
