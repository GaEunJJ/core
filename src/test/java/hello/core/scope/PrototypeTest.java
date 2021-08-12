package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("♡1. find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class); // 이때 init 호출
        System.out.println("♡3. find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class); // 이때 init 호출 (새로운 객체)

        System.out.println("♡5. PrototypeBean1 = " + prototypeBean1);
        System.out.println("♡6. PrototypeBean2 = " + prototypeBean2);     // 둘이 서로 다른 참조값 나옴

        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close(); // close안됨. 프로토타입이라 만들고 관리는 X

    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("♡2.4. PrototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("♡x SingletonBean.destory");
        }
    }
}
