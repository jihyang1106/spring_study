package com.example.inflearn_spring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.inflearn_spring.domain.Member;
import com.example.inflearn_spring.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemoryMemberRepository memberRepository;
	MemberService memberService;
	
	// 동작하기 전에 MemberService의 생성자에 넣어주기(DI 의존성 주입)
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void Join() {
		// given
		Member member = new Member();
		member.setName("spring");
		// when
		Long saveId = memberService.join(member);
		// then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test 
	void 중복회원예외() {
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		memberService.join(member1);
		
		
//		(1) try catch 문
//		try {
//			memberService.join(member2);
//			fail();
//		}catch(IllegalStateException e) {
//			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
//      (2) assertThrows
//		assertThrows(IllegalStateException.class, ()-> memberService.join(member2));

// 		(3) assertThrows + getMessage
		IllegalStateException e = assertThrows(IllegalStateException.class, 
				()->memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

	}
	@Test
	void findMembers() {
		
	}

	@Test
	void findOne() {
		
	}

}
