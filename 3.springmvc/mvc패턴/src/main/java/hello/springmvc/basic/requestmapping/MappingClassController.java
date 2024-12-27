package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

/*
    * 회원 목록 조회 : GET '/users'
    * 회원 등록 : POSER '/users'
    * 회원 조회 : GET '/users/{userId}'
    * 회원 수정 : PATCH '/users/{userId}'
    * 회원 삭제 : DELETE '/users/{userId}'
 */
@RequestMapping("/mapping/uesrs")
@RestController
public class MappingClassController {

    @GetMapping()
    public String user(){
        return "get users";
    }

    @PostMapping()
    public String addUser(){
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable int userId){
        return "get userId="+userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable int userId){
        return "update userId="+userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        return "delete userId="+userId;
    }
}
