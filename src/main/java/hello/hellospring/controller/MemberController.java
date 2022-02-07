package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/member/new")
    public String createMember
            654
    ouyrsa

}
