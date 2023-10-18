package aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Pointcut 재사용을 위한 공통 Pointcut 클래스
 */
public class CommonPointcut {

    @Pointcut("execution(public * chap07..*(..))")
    public void commonTarget(){
    }

}
