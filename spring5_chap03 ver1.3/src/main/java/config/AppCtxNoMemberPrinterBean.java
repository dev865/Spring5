package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;

@Configuration
public class AppCtxNoMemberPrinterBean {

    private MemberPrinter printer = new MemberPrinter();    // 빈으로 등록하지 않음

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }

//    @Bean
//    public MemberPrinter memberPrinter(){
//        return new MemberPrinter();
//    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter(memberDao(), printer);     // 고친곳
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
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