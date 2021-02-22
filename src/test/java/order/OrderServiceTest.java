package order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import yesol.core.member.Grade;
import yesol.core.member.Member;
import yesol.core.member.MemberService;
import yesol.core.member.MemberServiceImpl;
import yesol.core.order.AppConfig;
import yesol.core.order.Order;
import yesol.core.order.OrderService;
import yesol.core.order.OrderServiceImpl;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
