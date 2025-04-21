package hello.springcore.withoutspring.member;

public class MemberServiceImpl implements MemberService {

    // 분명히 추상화(인터페이스)를 의존하는것처럼 보이지만 구현체도 같이 의존하고 있다. DIP을 위반하고 있는거다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
