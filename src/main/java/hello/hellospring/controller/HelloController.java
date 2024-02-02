package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "/hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(value = "name", required = false) String name, Model model) { // required = false 옵션은 name의 값을 쿼리스트링으로 보내지 않아도 오류(400)가 나지않고 null로 반환해준다
        model.addAttribute("name", name); // key value
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = false) String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // 해당 메서드에 들어가있으면 HttpMessageConverter가 단순 문자면 StringConverter 아니면 JsonConverter가 동작한다 그러면 JSON객체로 변환하여 return 해줌
    // Jackson, Gson 등등이 있다 Gson은 구글에서 만들었다.
    public Hello helloApi(@RequestParam("name") String name) {
        return new Hello(name);
    }

    static class Hello { // getter setter = java bean 표준 방식
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Hello(String name) {
            this.name = name;
        }

    }

}
