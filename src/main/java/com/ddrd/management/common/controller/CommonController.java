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
import org.springframework.web.bind.annotation.*;

@RestController
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
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception {
        log.info("권한 확인 :: {}", UserRoleType.USER.roleName());
        return new ResponseEntity<>(loginService.login(request), HttpStatus.OK);
    }
    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }
    @GetMapping("/signUp/{userId}")
    public String signUp(@PathVariable(value = "userId") Long id){
        return "signUp";
    }
    @PutMapping

    @DeleteMapping

    @PatchMapping
    //등록
    @PostMapping("/signUp")
    public ResponseEntity<Boolean> signUp(@RequestBody LoginRequest request) throws Exception {
        return new ResponseEntity<>(loginService.register(request), HttpStatus.OK);
    }

}
