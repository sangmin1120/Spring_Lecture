package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/*
    v1. 쿼리 파라미터로 받아와서 출력
    v2. spring request-param 사용
    v3. 변수명과 파라미터가 같으면 생략할 수 있다.
    v4. @RequestParam 생략할 수 있다.
    Required. 필수값
    Map. query 문을 map 형식으로 받을 수 있다.
 */
@Slf4j
@Controller
public class RequestParamController {

/* RequestParam ------------------------------------------------------------*/
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username:{},age:{}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // Controller 라서 view 를 반환해야 하지만 String 을 반환하게 해줌
    @RequestMapping("/request-param-v2")
    public String requestParmaV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("username:{},age:{}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParmaV3(
            @RequestParam String username,
            @RequestParam int age){

        log.info("username:{},age:{}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParmaV4(String username, int age){

        log.info("username:{},age:{}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParmaRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) int age){

        log.info("username:{},age:{}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParmaMap(@RequestParam Map<String, String> map){

        log.info("username:{},age:{}", map.get("username"), map.get("age"));
        return "ok";
    }
/* ModelAttribute 사용 -----------------------------------------------------*/
    // ModelAttribute 사용 -> 생략도 가능
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("helloData:{}", helloData);
        return "ok";
    }
    // ModelAttribute 생략 -> 단순한 타입이 아닐 때 써준다.
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("helloData:{}", helloData);
        return "ok";
    }
}
