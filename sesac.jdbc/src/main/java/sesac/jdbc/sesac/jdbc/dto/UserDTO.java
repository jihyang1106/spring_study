package sesac.jdbc.sesac.jdbc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String name;
    private String nickname;
    private int no; // 클라이언트에게 전달할 때 값을 추가하기 위해서 생성함

}
