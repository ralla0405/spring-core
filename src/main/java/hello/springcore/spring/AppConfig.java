package hello.springcore.spring;

import hello.springcore.spring.discount.DiscountPolicy;
import hello.springcore.spring.discount.FixDiscountPolicy;
import hello.springcore.spring.member.MemberRepository;
import hello.springcore.spring.member.MemberService;
import hello.springcore.spring.member.MemberServiceImpl;
import hello.springcore.spring.member.MemoryMemberRepository;
import hello.springcore.spring.order.OrderService;
import hello.springcore.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
