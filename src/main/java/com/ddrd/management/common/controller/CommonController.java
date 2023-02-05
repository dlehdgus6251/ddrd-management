package com.ddrd.management.common.controller;
import com.ddrd.management.common.domain.LoginRequest;
import com.ddrd.management.common.domain.LoginResponse;
import com.ddrd.management.user.UserRoleType;
import com.ddrd.management.user.repository.UserRepository;
import com.ddrd.management.common.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CommonController extends BaseController{
    private final UserRepository userRepository;
    private final LoginService loginService;
    @GetMapping("/")
    public String home() { return "home"; }

    @GetMapping("/main")
    public String main(){
        return "main";
    }
    @GetMapping("/login/aa")
    public String login(){ return"login"; }
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception {
//        log.info("login 시도 :: {}, {}", request.getUserName(),request.getPassword());
//        return new ResponseEntity<>(loginService.login(request), HttpStatus.OK);
//    }
    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }
    @GetMapping("/signUp/{userId}")
    public String signUp(@PathVariable(value = "userId") Long id){
        return "signUp";
    }
    //등록
//    @PostMapping("/signUp")
//    public ResponseEntity<Boolean> signUp(@RequestBody LoginRequest request) throws Exception {
//        return new ResponseEntity<>(loginService.register(request), HttpStatus.OK);
//    }

}
