package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);           // 아이디 세팅
        store.put(member.getId(), member);  // store(map)에 저장
        return member;                      // 결과를 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이어도 감쌀 수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 파라미터로 넘어온 name이 getName과 동일할 경우를 찾으면 반환
        // 없으면 null 반환(Optional 로 인해)
        return store.values().stream()
                    .filter(member -> member.getName().equals(name))
                    .findAny();
    }

    @Override
    public List<Member> findAll() {
        // store에 있는 값들을 모두 반환
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
