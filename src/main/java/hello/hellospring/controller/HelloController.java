package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //get 방식으로 넘어온 url로 연결
    //  /hello url로 넘어오면 hello method 실행
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        //template에 있는 hello.html에 가서 렌더링(출럭해라)
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("user_input") String val, Model model) {
        model.addAttribute("key", val);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setInput(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getInput() {
            return name;
        }

        public void setInput(String name) {
            this.name = name;
        }
    }
}

