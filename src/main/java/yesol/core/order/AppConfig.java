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

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    // 두 번 호출 ?!?!?

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //그러나 결과로는 memberRepository는 한번만 호출된다 !! -> 스프링 컨테이너가 보장해주는 싱글톤
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() { // 인터페이스
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPoicy();
    }
}
