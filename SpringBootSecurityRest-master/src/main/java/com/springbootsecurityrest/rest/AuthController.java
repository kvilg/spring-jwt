package com.springbootsecurityrest.rest;

import com.springbootsecurityrest.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;



    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody com.springbootsecurityrest.model.User getAuthUser(@RequestBody String body) {

        System.out.println(body);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(body);
        if (auth == null) {
            return null;
        }
        System.out.println(body);
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        return Objects.nonNull(user) ? this.service.getByLogin(user.getUsername()) : null;
    }

}
