package spring;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Component 어노테이션에 값을 주지않으면 클래스 이름의 첫글자를 소문자로 바뀌어서 빈이름으로 사용한다.
 * 예) memberDao
 */
@Component
public class MemberDao {

    private static long nextId = 0;

    // Map의 key는 이메일, value는 멤버객체
    private Map<String, Member> map = new HashMap<>();

    public Member selectByEmail(String email){
        return map.get(email);
    }
    public void insert(Member member){
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    public void update(Member member){
        map.put(member.getEmail(), member);
    }

    public Collection<Member> selectAll(){
        return map.values();
    }
}