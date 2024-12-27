package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@Slf4j
@Controller
public class ResponseBodyController {

    /* Http body String 으로 응답 -----------------------------------------------------------------*/
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }
    // HttpEntity 이용
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    // String view 반환
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3(){
        return "ok";
    }

    /* Http body Json 으로 응답 ---------------------------------------------------------------------*/
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseJsonV1(){
        HelloData helloData = new HelloData();
        helloData.setUsername("UserA");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }
    // 그냥 응답
    @ResponseStatus(HttpStatus.OK) // 리턴 상태 코드를 정할 수 있음
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseJsonV2(){
        HelloData helloData = new HelloData();
        helloData.setUsername("UserA");
        helloData.setAge(20);

        return helloData;
    }
}
