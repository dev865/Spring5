package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
    @Autowired
    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd){
        Member member = memberDao.selectByEmail(email);
        if(member == null){
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

//    의존 자동 주입으로 setter메소드 불필요
//    public void setMemberDao(MemberDao memberDao){
//        this.memberDao = memberDao;
//    }
}
