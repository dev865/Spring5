package chap02_1;

/**
 * AnnotationConfigApplicationContext 클래스는 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
 */
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);
        /**
         * 이름이 greeter인 Bean 객체를 구해서 g1과 g2 변수에 할당한다.
         * g1과 g2가 같은 객체인지 여부를 콘솔로 출력한다.
         */
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println("(g1 == g2) = " + (g1 == g2));       // true
        /**
         * 스프링에서 별도 설정이 없다면 Bean 객체는 한개만 생성하며, 이 Bean 객체는 싱글톤 범위를 갖는다.
         */
        ctx.close();
    }
}
