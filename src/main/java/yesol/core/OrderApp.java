package yesol.core;

import yesol.core.member.Grade;
import yesol.core.member.Member;
import yesol.core.member.MemberService;
import yesol.core.member.MemberServiceImpl;
import yesol.core.order.Order;
import yesol.core.order.OrderService;
import yesol.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order= orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);

    }
}
