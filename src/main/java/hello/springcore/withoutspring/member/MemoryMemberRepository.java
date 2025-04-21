package hello.springcore.withoutspring.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // HashMap 은 동시성 이슈가 있을 수 있기 때문에 ConcurrentHashMap 을 사용해야 실무에 적합하다. 여기서는 예제이므로 간단하게 HashMap으로 구현한다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }
}
