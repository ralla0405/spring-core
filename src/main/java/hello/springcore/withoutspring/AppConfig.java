package hello.springcore.withoutspring;

import hello.springcore.withoutspring.discount.DiscountPolicy;
import hello.springcore.withoutspring.discount.FixDiscountPolicy;
import hello.springcore.withoutspring.member.MemberRepository;
import hello.springcore.withoutspring.member.MemberService;
import hello.springcore.withoutspring.member.MemberServiceImpl;
import hello.springcore.withoutspring.member.MemoryMemberRepository;
import hello.springcore.withoutspring.order.OrderService;
import hello.springcore.withoutspring.order.OrderServiceImpl;

// AppConfig 애플리케이션의 전체 동작 방식을 구성하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
// 해당 설정 클래스로 인해 애플리케이션 코드의 DIP 와 OCP 원칙을 모두 지킬 수 있게 된다.
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
