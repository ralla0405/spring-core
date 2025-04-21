package hello.springcore.withoutspring;

import hello.springcore.withoutspring.discount.FixDiscountPolicy;
import hello.springcore.withoutspring.member.MemberService;
import hello.springcore.withoutspring.member.MemberServiceImpl;
import hello.springcore.withoutspring.member.MemoryMemberRepository;
import hello.springcore.withoutspring.order.OrderService;
import hello.springcore.withoutspring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
