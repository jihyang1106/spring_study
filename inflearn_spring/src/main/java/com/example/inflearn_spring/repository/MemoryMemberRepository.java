package com.example.inflearn_spring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.inflearn_spring.domain.Member;
import org.springframework.stereotype.Repository;
public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	@Override
	// 회원정보를 store Map에 저장 후 member를 반환
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	// 인자(매개변수)로 받은 id와 일치하는 값을 store Map에서 꺼내서 반환
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	// filter( )내의 람다식을 통해, 인자로 받은 name과 member.getName( )이
	// 일치하는지 비교 후 일치하는 게 하나라도 있다면 반환
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(member->member.getName().equals(name))
				.findAny();
	}

	@Override
	// store에 있는 모든 member들을 반환
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}

}
