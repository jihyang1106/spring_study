package com.example.inflearn_spring.repository;

import java.util.List;
import java.util.Optional;

import com.example.inflearn_spring.domain.Member;

public interface MemberRepository {

	Member save(Member member);  // 회원 저장
	
	Optional<Member> findById(Long id); // id로 찾기
	Optional<Member> findByName(String name); // name으로 찾기
	
	List<Member> findAll(); // 리스트로 모두 찾기
}
