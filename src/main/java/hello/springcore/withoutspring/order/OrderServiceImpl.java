package hello.springcore.withoutspring.order;

import hello.springcore.withoutspring.discount.DiscountPolicy;
import hello.springcore.withoutspring.discount.FixDiscountPolicy;
import hello.springcore.withoutspring.member.Member;
import hello.springcore.withoutspring.member.MemberRepository;
import hello.springcore.withoutspring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 회원의 등급만 넘겨도 되지만 추후 프로젝트 확장성을 고려해서 member 자체를 넘긴다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
