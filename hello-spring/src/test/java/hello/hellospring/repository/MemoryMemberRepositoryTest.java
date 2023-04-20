package hello.hellospring.repository;

import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    // MemberRepository를 구현한 구현체의 MemboryMemberRepository 객체 생성
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");   // 멤버 객체 이름을 임의로 생성해서
        repository.save(member);    // MemoryMemberRepository에 이름을 저장

        Member actual = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, actual);
//        assertThat(actual).isEqualTo(member);

    }

    @Test
    // 2명의 이름을 member에 저장하고, result 객체와 각 member를 비교하는 테스트
    public void findByName() {
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        Member actual = repository.findByName("member2").get();
//        Member actual = repository.findByName(member1.getName()).get();
        Assertions.assertEquals(member2, actual);
//        assertThat(actual).isEqualTo(member2);
    }


    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


    // 테스트가 끝날 때마다 지워주는 메서드
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
}
