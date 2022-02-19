package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;



    @Test
    void 회원가입() {
        //given - 상황이 주어짐
        Member member = new Member();
        member.setName("spring");

        //when - 실행 했을 떄
        Long saveId = memberService.join(member);

        //then - 결과가 나와야 함
        Member findMembet = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMembet.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when

        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    }


    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}