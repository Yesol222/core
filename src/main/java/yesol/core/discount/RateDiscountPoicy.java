package yesol.core.discount;

import yesol.core.member.Grade;
import yesol.core.member.Member;

public class RateDiscountPoicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100; //의심스러운 부분
        } else {
            return 0;
        }
    }
}
