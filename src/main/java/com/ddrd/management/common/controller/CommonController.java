package com.ddrd.management.common.controller;
//안녀엉

//충돌

//ㅋ_ㅋ📱📱🍲🍝🤷‍♂️💗☺🏠
import com.ddrd.management.user.domain.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class CommonController extends BaseController{
    @GetMapping("/")
    public String home() { return "home"; }
    @GetMapping("/api/v1/do")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck() {
        return "ok3";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public void signUp(UserDto userDto){
        log.info("userDto :: {}",userDto.toString());
    }

}
