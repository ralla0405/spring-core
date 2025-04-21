package hello.springcore.withoutspring.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
