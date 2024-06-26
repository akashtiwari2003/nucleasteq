package com.example.akash.demoproject.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;
    @GetMapping("/")
    public String sayHello(){
        return ("Hello World!!");
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return ("Run a hard 5k");
    }

    @GetMapping("/customvalues")
    public String getCustomValues(){
        return (coachName + " from " + teamName);
    }
}
