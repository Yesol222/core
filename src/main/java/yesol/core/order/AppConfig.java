package yesol.core.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yesol.core.discount.DiscountPolicy;
import yesol.core.discount.FixDiscountPolicy;
import yesol.core.discount.RateDiscountPoicy;
import yesol.core.member.MemberRepository;
import yesol.core.member.MemberService;
import yesol.core.member.MemberServiceImpl;
import yesol.core.member.MemoryMemberRepository;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() { // 인터페이스
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPoicy();
    }
}
