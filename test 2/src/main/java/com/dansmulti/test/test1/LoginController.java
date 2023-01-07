package com.dansmulti.test.test1;


import com.dansmulti.test.test2dan3.GeneratedJwt;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final GeneratedJwt generatedJwt;

    @PostMapping
            ("/login")
    public String login(@RequestBody LoginRequestDto request) throws NotFoundException {
        return loginService.login(request.getUsername(), request.getPassword());
    }


    @PostMapping("/generateToken")
    public String generate(@RequestParam String username){
        return generatedJwt.getStringJwt(username);
    }

}
