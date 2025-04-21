package hello.springcore.spring;

import hello.springcore.spring.member.MemberService;
import hello.springcore.spring.member.Grade;
import hello.springcore.spring.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        // ApplicationContext 를 스프링 컨테이너라고 한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
        // 이렇게 애플레키에션을 매번 띄워서 눈으로 확인하는건 어렵다.
        // Junit을 사용해 Test 패키지에 별도로 테스트를 구현하는것이 옳다.
    }
}
