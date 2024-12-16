package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {
    // mapper
    private ObjectMapper objectMapper = new ObjectMapper();

    /* RequestBody - JSON --------------------------------------------------------------------- */
    /*
    content-type : application/json
     */
    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);
        HelloData data = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={},age={}",data.getUsername(),data.getAge());

        response.getWriter().write("ok");
    }

    // v2 : RequestBody 받아 -> objectMapper
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

        log.info("messageBody={}",messageBody);
        HelloData data = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={},age={}",data.getUsername(),data.getAge());

        return "ok";
    }

    // v3 : 객체로 받아
    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData data) throws IOException {

        log.info("username={},age={}",data.getUsername(),data.getAge());

        return "ok";
    }

    // v4 : HttpEntity
    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> httpEntity) throws IOException {
        HelloData data = httpEntity.getBody();
        log.info("username={},age={}",data.getUsername(),data.getAge());

        return "ok";
    }

    // v5 : 객체를 반환
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData data) throws IOException {
        log.info("username={},age={}",data.getUsername(),data.getAge());

        return data;
    }
}
