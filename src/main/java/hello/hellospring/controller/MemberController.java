package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

/**
 * spring이 실행될때 스프링 컨테이너에 얘가 등록된다. 객체를 생성하여 들고있다.
 */

@Controller
public class MemberController {

    // 필드 주입 -
    // 생성자 주입 - 해당 객체가 생성될때 주입이 되기때문에 권장
    // setter 주입 - 세터 메서드가 호출이 되기때문에 권장 X

    private final MemberService memberService;

    @Autowired // 의존관계 주입 (DI)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) throws SQLException {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
