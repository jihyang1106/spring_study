package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    // 회원 서비스를 만들기 위해 MemberRepository 인스턴스 필요
    private final MemberRepository memberRepository;

    // Autowired 생략(생성자가 한 개만 있기 때문)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 중복회원 검증 및 회원가입 후 가입한 id 반환
    public Long join(Member member) {
        validateDuplicateName(member); // ex) 중복회원검증(같은 이름 있으면 안됨)
        memberRepository.save(member);
        return member.getId();  // 회원가입 후 id 반환
    }

    // 중복회원 검증 메서드
    // 메서드 추출(추출할 부분 ctrl+Alt+M)
    private void validateDuplicateName(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m-> {
           throw new IllegalStateException("이미 존재하는 이름입니다!");
       });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 한명 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
