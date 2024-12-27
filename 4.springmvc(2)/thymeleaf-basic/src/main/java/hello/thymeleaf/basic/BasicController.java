package hello.thymeleaf.basic;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    /*-basic 출력 연습-------------------------------------------------------*/
    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "basic/text-unescaped";
    }
    /* 변수 연습----------------------------------------------------------*/
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String,User> map = new HashMap<>();
        map.put("userA",userA);
        map.put("userB",userB);

        model.addAttribute("user",userA);
        model.addAttribute("users",list);
        model.addAttribute("userMap",map);

        return "basic/variable";

    }
    /* 기본 제공하는 객체 ----------------------------------------------------*/
    @GetMapping("/basic-objects")
    public String basicObjects(Model model , HttpSession session,
                               HttpServletRequest request, HttpServletResponse response) {
        session.setAttribute("sessionData","Hello Session");
        model.addAttribute("request",request);
        model.addAttribute("response",response);
        model.addAttribute("servletContext",request.getServletContext());
        return "basic/basic-objects";
    }

    @Component("helloBean")
    static class HelloBean{
        public String hello(String data){
            return "Hello " + data;
        }
    }
    /* URL 링크------------------------------------------------------------*/
    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1","data1");
        model.addAttribute("param2","data2");
        return "basic/link";
    }
    /* 리터럴 ------------------------------------------------------------*/
    @GetMapping("/literal")
    public String literal(Model model){
        model.addAttribute("data","Spring!");
        return "basic/literal";
    }
    /* 연산 ------------------------------------------------------------*/
    @GetMapping("/operation")
    public String operation(Model model){
        model.addAttribute("nullData",null);
        model.addAttribute("data","Spring!");
        return "basic/operation";
    }
    /* 속성 ------------------------------------------------------------*/
    @GetMapping("/attribute")
    public String attribute(){
        return "basic/attribute";
    }
    /* 반복 ------------------------------------------------------------*/
    @GetMapping("/each")
    public String each(Model model){
        addUsers(model);
        return "basic/each";
    }

    /* 반복 ------------------------------------------------------------*/
    @GetMapping("/condition")
    public String condition(Model model){
        addUsers(model);
        return "basic/condition";
    }
    /* 주석 ------------------------------------------------------------*/
    @GetMapping("/comments")
    public String comments(Model model){
        model.addAttribute("data","Spring!");
        return "basic/comments";
    }
    /* 블록 ------------------------------------------------------------*/
    @GetMapping("/block")
    public String block(Model model){
        addUsers(model);
        return "basic/block";
    }
    /* 자바스크립 인라인------------------------------------------------------------*/
    @GetMapping("/javascript")
    public String javascript(Model model){
        model.addAttribute("user",new User("userA",10));
        addUsers(model);

        return "basic/javascript";
    }

    /* 예시 객체------------------------------------------------------------*/
    @Data
    static class User{
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }
    private void addUsers(Model model){
        List<User> list = new ArrayList<>();
        list.add(new User("userA",10));
        list.add(new User("userB",20));
        list.add(new User("userC",30));

        model.addAttribute("users",list);
    }
}
