package com.dansmulti.test.test1;

import com.dansmulti.test.test2dan3.GeneratedJwt;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private GeneratedJwt generatedJwt;

    public String login(String username, String password) throws NotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new NotFoundException("User Not Found"));
        if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
            // Return error if username or password is invalid
            return "Error: Invalid username or password";
        } else {
            // Generate JWT and return it if login is successful
            String token =  generatedJwt.getStringJwt(username);
            user.setToken(token);
            userRepository.save(user);
            return token;
        }
    }




}
