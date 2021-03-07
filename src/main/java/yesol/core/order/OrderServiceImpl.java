package yesol.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import yesol.core.annotation.MainDiscountPolicy;
import yesol.core.discount.DiscountPolicy;
import yesol.core.discount.FixDiscountPolicy;
import yesol.core.member.Member;
import yesol.core.member.MemberRepository;
import yesol.core.member.MemoryMemberRepository;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); OCP, DIP 위반
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //인터페이스에만 의존

//    //수정자 (setter) 주입. "선택, 변경" 가능한 주입
//    @Autowired
//    public void  setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        this.discountPolicy = discountPolicy;
//    }

    //생정자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //order service는 discount policy와 독립되어있음.
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
