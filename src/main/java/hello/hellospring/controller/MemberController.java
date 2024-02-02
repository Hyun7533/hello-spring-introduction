package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * spring이 실행될때 스프링 컨테이너에 얘가 등록된다. 객체를 생성하여 들고있다.
 */

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 의존관계 주입 (DI)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
