package order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import yesol.core.member.Grade;
import yesol.core.member.Member;
import yesol.core.member.MemberService;
import yesol.core.member.MemberServiceImpl;
import yesol.core.order.Order;
import yesol.core.order.OrderService;
import yesol.core.order.OrderServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
