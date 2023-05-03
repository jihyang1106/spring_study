package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    // 회원 서비스를 만들려면 MemberRepository 인스턴스가 필요
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원가입(MemberRepository에서 save만 호출해주면 됨)
    public Long join(Member member){
        validateDuplicateName(member); // 중복회원검증
        memberRepository.save(member);
        return member.getId();  // 회원가입을 하면 id를 반환해준다.
    }
    // 메서드 추출 ( 추출할 부분 드래그 + Ctrl + Alt + M)
    private void validateDuplicateName(Member member) {
        // Optional<Member>를 빼서 코드를 작성하는 것은 권장하지 않는다.
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll(); // findAll은 데이터타입이 List이기 때문에 OK
    }

    // 한 명의 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
