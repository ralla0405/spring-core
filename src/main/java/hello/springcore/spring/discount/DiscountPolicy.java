package hello.springcore.spring.discount;

import hello.springcore.spring.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
