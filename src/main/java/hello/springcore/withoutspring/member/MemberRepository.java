package hello.springcore.withoutspring.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);
}
