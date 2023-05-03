package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝날때마다 지워주는 코드 생성
    // import org.junit.jupiter.api.AfterEach;
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    // import org.junit.jupiter.api.Test
    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);

        // 반환 타입이 Optional이다. repository.findById(member.getId());
        // Optional에서 값을 꺼낼 때는 get() (테스트 코드니까 get으로, 원래는 좋은 방법x)
        Member result = repository.findById(member.getId()).get();
        // import static org.assertj.core.api.Assertions.*;
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        // 좀더 정교한 테스트를 위해서 (변수이름 바꾸기: 드래그+shift+F6)
        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}

