package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    * log test
    * @RestController : 원래 Controller -> 뷰 이름이 문자열로 반환돼서 뷰 리졸버를 찾는 것이다.
    *                   근데 , RestController -> REST API , string 그대로 반환된다.
 */
@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info("info log={} = " , name);
        log.warn("warn log={} = " , name);
        log.error("error log={} = " , name);

        return "ok";
    }
}
