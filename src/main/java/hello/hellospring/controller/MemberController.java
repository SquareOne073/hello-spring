package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자에 autowired 를 할 경우
    // spring 이 spring container 에 있는 memeberService 를 가져다가 연결시겨 줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // DI 에서 3가지가 있는데 위의 겅우는 1) 생성자 주입
    // @Autowired private MemberService memberService; <-- 2) 필드 주입
    // 3) Setter 주입 -- public 으로 열려 있어야 하기에 약간의 단점

    // GET 방식 - 그냥 해당 페이지가 뿌려짐 (주로 조회할 때 사용 / 디폴트)
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // POST - 데이터 등록, 수정 할 때 주로 사용
    @PostMapping("/members/new")
    public String create(MemberForm form){
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
