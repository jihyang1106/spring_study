package com.example.inflearn_spring.service;

import java.util.List;
import java.util.Optional;

import com.example.inflearn_spring.domain.Member;
import com.example.inflearn_spring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	// memberRepository를 외부에서 넣어주도록 생성
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	// 회원가입
	public Long join(Member member) {
		validateDuplicateMember(member);// 같은 이름이 있는 중복 회원 검증
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}

	// 전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	// Id로 한 회원만 조회
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
}
