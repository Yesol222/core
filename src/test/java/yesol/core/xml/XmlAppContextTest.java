package yesol.core.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import yesol.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContextTest {
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new
                GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService",
                MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
