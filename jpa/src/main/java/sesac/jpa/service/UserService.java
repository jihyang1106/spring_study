package sesac.jpa.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.jpa.domain.UserEntity;
import sesac.jpa.dto.UserDTO;
import sesac.jpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insertUser(UserEntity user) {
        userRepository.save(user);
    }

    // 리턴 값은 name이 나와야 함
    public void login(UserEntity user) {
        Optional<UserEntity> user1 = userRepository.findByIdPw(user);
        System.out.println(user1);
    }

}
