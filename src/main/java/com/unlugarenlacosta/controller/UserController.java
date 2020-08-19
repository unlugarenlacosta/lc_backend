package com.unlugarenlacosta.controller;

import com.unlugarenlacosta.entities.User;
import com.unlugarenlacosta.interfaces.UserRepository;
import com.unlugarenlacosta.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/username")
    public ResponseEntity get(@RequestParam String name) {
        User user = userRepository.findByUsername(name);
        return new ResponseEntity(new GenericResponse("OK", user), HttpStatus.OK);
    }
}
