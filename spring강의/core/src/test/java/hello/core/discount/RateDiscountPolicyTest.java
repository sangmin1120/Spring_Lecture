package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip는 10% 할인이 적용되어야 한다")
    void Vip_OK(){
        // given
        Member member = new Member(1L,"MemberVIP", Grade.Vip);

        // when
        int discount = discountPolicy.discount(member,10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Vip가 아니면 할인이 적용되지 않아야 한다.")
    void Vip_NO(){
        // given
        Member member = new Member(1L,"MemberBasic", Grade.Basic);

        // when
        int discount = discountPolicy.discount(member,10000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}