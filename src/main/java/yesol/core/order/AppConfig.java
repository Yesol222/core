package yesol.core.order;

import yesol.core.discount.DiscountPolicy;
import yesol.core.discount.FixDiscountPolicy;
import yesol.core.member.MemberRepository;
import yesol.core.member.MemberService;
import yesol.core.member.MemberServiceImpl;
import yesol.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    private MemberRepository memberRepository() { // 인터페이스
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
