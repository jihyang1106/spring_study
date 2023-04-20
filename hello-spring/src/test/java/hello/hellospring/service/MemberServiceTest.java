package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class MemberServiceTest {
    MemberService memberService;
    // DB에 누적된 데이터를 삭제하기 위해 MemoryMemberRepository에 있는 clearStore()에 가져와야함
    MemoryMemberRepository memberRepository;

    // 생성자 주입 MemberService를 생성할 때 외부에서 넣어주기
    // DI로 인해 MemberService 객체와 MemberServiceTest 객체가 동일한 Repository 공유
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("member");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원예외() {
        // given
        Member member1 = new Member();
        member1.setName("member1");

        Member member2 = new Member();
        member2.setName("member1"); // 중복 이름 기입

        // when
        memberService.join(member1);

        // (1) 람다식
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다!");

        // (2) try - catch 문
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalArgumentException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다!");
//        }

    }

    // TEST가 끝날 때마다 DB의 값 청소
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    void findOne() {

    }
}
