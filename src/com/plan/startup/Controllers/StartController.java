package com.plan.startup.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by anirudh.b on 04/02/17.
 */
@RestController
public class StartController {
    @CrossOrigin
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getAllCustomAlerts() throws Exception {
        return "OK";
    }
}