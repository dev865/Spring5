package chap02;

/**
 * AnnotationConfigApplicationContext 클래스는 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
 */
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        /**
         * AppContext 클래스를 생성자 파라미터로 전달한다.
         * AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화한다.
         */
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);
        /**
         * getBean() 메서드는 AnnotationConfigAppliicationContext가 자바설정을 읽어와 생성한 빈 객체를 검색할 때 사용된다.
         * 첫번째 파라미터는 @Bean 어노테이션의 메서드 이름인 빈 객체의 이름
         * 두번째 파라미터는 검색할 빈 객체의 타입이다.
         * (AppContext 클래스를 다시 봐보면 @Bean 메서드의 이름이 "greeter" 생성한 객체의 리턴 타입이 Greeter이다.)
         */
        Greeter g = ctx.getBean("greeter", Greeter.class);

        String msg = g.greet("스프링");
        System.out.println(msg);
        ctx.close();
    }
}
