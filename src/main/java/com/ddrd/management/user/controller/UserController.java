package com.ddrd.management.user.controller;

import com.ddrd.management.common.domain.LoginResponse;
import com.ddrd.management.common.service.LoginService;
import com.ddrd.management.user.domain.UserDto;
import com.ddrd.management.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/main")
    public String userView(Model model){
        List<UserDto> userList = userService.getUsers();
        model.addAttribute("userList", userList);
        return"/user/main";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<UserDto> getUsers(){
        List<UserDto> userList = userService.getUsers();
        return userList;
    }
    @GetMapping("{userId}")
//    public ResponseEntity<LoginResponse> getUser(@PathVariable("userId") String userId) throws Exception {
//
//        return new ResponseEntity<>( loginService.getuserEntity(userId), HttpStatus.OK);
//    }
    @PostMapping("/")
    @ResponseBody
    public UserDto insertUser(@RequestBody UserDto userDto){
        return userDto;
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") long id) {

    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {

    }
}
