package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/*
    * 요청 매핑
    * url 요청 ( 배열도 가능 ) -> 어떤 method 가 호출이 된다.
    * 1. RequestMapping
    * 2. GetMapping
    * 3. pathVariable
    * 4. query param 조건 매핑 : param 의 정보가 있어야 호출이 된다.
    * 5. content-type 매핑
 */
@RestController
@Slf4j
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("hello-basic");
        return "ok";
    }

    /**
     * method 특정 HTTP 메서드 요청만 허용
     * GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
        * pathVariable
        * url 자체에 값이 들어가 있다.
     **/
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId = {}",userId);
        return "ok";
    }

    /**
        * query param 조건 매핑
        * param 이 있어야 호출이 된다.
     **/
    @GetMapping(value = "/mapping-param",params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     * content-type 헤더 기반 추가 매핑 media type
     * 헤더의 content-type이 consumes 일 때만 호출된다.
     */
    @PostMapping(value = "/mapping-consume",consumes = "application/json")
    public String mappingConsume(){
        log.info("mappingConsume");
        return "ok";
    }
}
