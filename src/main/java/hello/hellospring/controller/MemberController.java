package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자에 autowired 를 할 경우
    // spring 이 spring container 에 있는 memeberService 를 가져다가 연결시겨 줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}
