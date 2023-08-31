package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc(){
        return new ChangePasswordService();
    }

//    @Bean
//    public MemberPrinter memberPrinter(){
//        return new MemberPrinter();
//    }

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
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    /**
     * setPrinter()안에 이름과 이메일만 출력하는 프린터를 넣었지만
     * 이미 MemberInfoPrinter클래스 안에서 Autowired로 의존자동주입받은 memberPrinter1이 실행된다.
     */
    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setPrinter(memberPrinter2());
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

    @Bean
    public VersionPrinter oldVersionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(4);
        versionPrinter.setMinorVersion(3);
        return versionPrinter;
    }

}