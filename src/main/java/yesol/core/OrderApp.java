package yesol.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yesol.core.member.Grade;
import yesol.core.member.Member;
import yesol.core.member.MemberService;
import yesol.core.member.MemberServiceImpl;
import yesol.core.order.AppConfig;
import yesol.core.order.Order;
import yesol.core.order.OrderService;
import yesol.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order= orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);

    }
}
