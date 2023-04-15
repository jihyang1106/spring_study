package sesac.jdbc.sesac.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.jdbc.sesac.jdbc.domain.User;
import sesac.jdbc.sesac.jdbc.domain.UserEntity;
import sesac.jdbc.sesac.jdbc.dto.UserDTO;
import sesac.jdbc.sesac.jdbc.mapper.MainMapper;
import sesac.jdbc.sesac.jdbc.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    @Autowired
    private UserRepository userRepository;

    // myBatis
//    public List<UserDTO> getUserList() {
//        // userDTO가 담긴 List를 controller에 넘겨준다.
//        List<User> result = mainMapper.retrieveAll(); // selectAll()과 동일
//        List<UserDTO> users = new ArrayList<UserDTO>();
//
//        for(int i=0; i<result.size();i++) {
//            UserDTO user = new UserDTO();
//            user.setId(result.get(i).getId());
//            user.setName(result.get(i).getName());
//            user.setNickname(result.get(i).getNickname());
//            user.setNo(i+1); // no는 전달하기 위한 값
//
//            users.add(user);
//        }
//        return users;
//    }
//
//    public void addUser(User user) {
//        mainMapper.insertUser(user);
//    }

    // jpa
    public List<UserDTO> getUserList() {
        List<UserEntity> result = userRepository.findAll(); // select * from
        List<UserDTO> users = new ArrayList<UserDTO>();

        for(int i=0; i<result.size();i++) {
            UserDTO user = new UserDTO();
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setNickname(result.get(i).getNickname());
            user.setNo(i+1); // no는 전달하기 위한 값

            users.add(user);
        }
        return users;
    }

    public void addUser(UserEntity user) {
        userRepository.save(user);  // insert into
    }

    public ArrayList<UserDTO> getUserName(String name) {
        Optional<UserEntity> user = userRepository.findByName(name);
        ArrayList<UserDTO> userList = new ArrayList<>();

        if(user.isPresent()) {
            UserDTO dto = new UserDTO();
            dto.setId(user.get().getId());
            dto.setNo(0);
            dto.setName(user.get().getName());
            dto.setNickname(user.get().getNickname());
            userList.add(dto);
        }
        return userList;
    }


}
