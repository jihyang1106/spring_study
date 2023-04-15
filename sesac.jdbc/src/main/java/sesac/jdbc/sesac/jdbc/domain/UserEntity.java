package sesac.jdbc.sesac.jdbc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity  // 해당 클래스가 Entity 클래스라는 것을 알려준다.
@Table(name="user")  // 테이블 이름 명시
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue // AutoIncrement
    private int id;  // id primary key auto_increment

    @Column(length = 5, nullable = false)  // 길이, null 허용 여부
    private String name;

    // nickname varchar(10) not null
    @Column(length = 10, nullable = false)
    private String nickname;

}
