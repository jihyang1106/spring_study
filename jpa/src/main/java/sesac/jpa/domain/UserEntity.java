package sesac.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user")
@Getter
@Setter
public class UserEntity {

    @Id
    private String id;

    @Column(length=10, nullable = false)
    private String pw;

    @Column(length=10, nullable = false)
    private String name;

}
