package com.geekykel.globalaccelerex.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kelvin on 09/03/2020
 *
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/home")
    @ApiOperation(value = "Test Home Controller")
    public String home() {
        return "Welcome to Global Accelerex Application.";
    }

}
