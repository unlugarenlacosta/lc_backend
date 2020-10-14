package com.dimetulugar.email.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/email")
public class EmailRest {

    @Autowired
    private EmailPort emailPort;

    @PostMapping(value = "/send")
    @ResponseBody
    public boolean SendEmail(@RequestBody EmailBody emailBody)  {
        return emailPort.sendEmail(emailBody);
    }
}
