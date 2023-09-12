package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.*;

@Configuration
@ComponentScan(basePackages = {"spring", "spring2"})
public class AppCtx {

    /**
     *  @Component대상인 MemberDao를 직접 수동 등록하였을경우 수동 등록한 빈이 우선한다.
     *  즉, MemberDao 타입 빈은 AppCtx에서 정의한 한 개만 존재한다.
     */
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    /**
     * 만약 memberDao2 라는 빈을 수동 등록한다면
     * @Component로 등록된 memberDao라는 이름의 빈과 다른 빈이다.
     * (위의 수동등록한 memberDao()가 없고 MemberDao클래스의 @Component를 사용한다는 가정하의 설명)
     */
    @Bean
    public MemberDao memberDao2(){
        return new MemberDao();
    }
    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1(){
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2(){
        return new MemberSummaryPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

}