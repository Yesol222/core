package yesol.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import yesol.core.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            //spring container 관리 x 한 클래스 사용
            //의존 관게가 없기 때문에 ac 메서드 자체가 호출이 안된다
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired()
        public void setNoBean2(@Nullable Member noBean2){
            //null 로 리턴
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired()
        public void setNoBean3(Optional<Member> noBean3){
            //Optional.empty 객체가 리턴됨
            System.out.println("noBean3 = " + noBean3);
        }

    }

}
