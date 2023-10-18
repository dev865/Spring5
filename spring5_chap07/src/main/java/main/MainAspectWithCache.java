package main;

import chap07.Calculator;
import config.AppCtxWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {

    public static void main(String[] Args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);

        Calculator cal = ctx.getBean("calculator", Calculator.class);
        System.out.println(cal.factorial(7));

        System.out.println(cal.factorial(7));
        System.out.println(cal.factorial(5));
        System.out.println(cal.factorial(5));
        ctx.close();
    }

}