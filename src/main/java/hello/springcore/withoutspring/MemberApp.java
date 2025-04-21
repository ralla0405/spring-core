package hello.springcore.withoutspring;

import hello.springcore.withoutspring.member.Grade;
import hello.springcore.withoutspring.member.Member;
import hello.springcore.withoutspring.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
        // 이렇게 애플레키에션을 매번 띄워서 눈으로 확인하는건 어렵다.
        // Junit을 사용해 Test 패키지에 별도로 테스트를 구현하는것이 옳다.
    }
}
