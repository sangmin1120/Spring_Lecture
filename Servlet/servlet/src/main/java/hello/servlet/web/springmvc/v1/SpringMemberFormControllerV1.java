package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    * v1 : new-form
    * @Controller(class) -> bean 등록 , RequestMappingHandlerMapping 호출
    * @RequestMapping(method) -> url 맞춰 handlerAdapter 찾음
    * ModelAndView 반환
 */
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
