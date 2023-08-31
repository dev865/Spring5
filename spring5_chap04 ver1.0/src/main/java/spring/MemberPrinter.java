package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {
    /**
     * 자동주입할 빈 객체가 존재하지않을 시 필드에도 아래 세터메서드처럼 3가지 방법으로 적용할 수 있다.
     */
    @Autowired(required = false)
    private DateTimeFormatter dateTimeFormatter;

    @Autowired
    @Nullable
    private DateTimeFormatter dateTimeFormatter1;

    @Autowired
    private Optional<DateTimeFormatter> dateTimeFormatterOpt;

    public MemberPrinter(){
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    }

    // printf 출력서식 %d: 정수, %f: 실수, %c:문자, %s: 문자열, %t: 시간?
    public void print(Member member) {
        if(dateTimeFormatter == null){
            System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
                    member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    /**
     * Optional을 필드값에 썻을 경우 print 메서드도 변경이 필요하다.
     * Optinal객체를 DateTimeFormatter 객체로 변환하는 작업.
     */
    public void printOptinal(Member member) {
        DateTimeFormatter dateFormatter = dateTimeFormatterOpt.orElse(null);

        if(dateTimeFormatter == null){
            System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
                    member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    /**
     * setter메서드에 의존자동주입할 객체가 존재 하지 않을 경우 3가지 방법을 사용해본다.
     * (required=false)는 대상 빈이 존재하지않을시 메서드를 호출하지 않는다.
     * 즉 값을 할당하지 않는다.
     */
    @Autowired(required = false)
    public void setDateFormatter(DateTimeFormatter dateTimeFormatter){
        this.dateTimeFormatter = dateTimeFormatter;
    }
    /**
     * 스프링5부터는 자바8의 Optional을 사용해도 된다.
     * 대상 빈이 존재하지않으면 값이 없는 Optinal을 할당한다.
     */
    @Autowired
    public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt){
        if(formatterOpt.isPresent()){
            this.dateTimeFormatter = formatterOpt.get();
        } else {
            this.dateTimeFormatter = null;
        }
    }

    /**
     * @Nullable과 (required=false)의 차이점은 메서드를 호출하는지 여부이다.
     * @Nullable은 의존자동주입할 객체가 존재하지 않아도 호출한다.
     * 일치하는 빈 객체가 없다면 null을 할당한다.
     */
    @Autowired
    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter){
        this.dateTimeFormatter = dateTimeFormatter;
    }
}