package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "Spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 문자형식 그대로 나옴 html
    @GetMapping("hello-string")
    @ResponseBody   // http 에서의 body 부분에 이 데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;   // "hello spring"
    }

    // json 방식으로 나옴
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        // 객체 Hello -> 밑에 static class Hello
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {

        private String name;

        // 프로퍼티 접근 방식 - getter-setter
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }




}
