package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체 저장하는 저장소 인터페이스
public interface MemberRepository {

    Member save(Member member);         // 회원 저장
    Optional<Member> findById(Long id); // ID로 회원찾기
    Optional<Member> findByName(String name); // name으로 회원찾기
    List<Member> findAll();  // 회원 정보 조회
}
