package yesol.core.order;

import yesol.core.discount.DiscountPolicy;
import yesol.core.discount.FixDiscountPolicy;
import yesol.core.member.Member;
import yesol.core.member.MemberRepository;
import yesol.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //order service는 discount policy와 독립되어있음.
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
