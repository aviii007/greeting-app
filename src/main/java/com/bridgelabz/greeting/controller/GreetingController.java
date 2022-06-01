package com.bridgelabz.greeting.controller;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.service.GreetingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/greeting")
@RestController
public class GreetingController {

    @Autowired
    GreetingServiceI greetingServiceI;

    @GetMapping("/getdata")
    public String Hello() {
        return "Hello World";
    }

    //@RequestMapping(value = {"", "/", "/home"},method = RequestMethod.GET)
    @GetMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello from Bridgelabz!!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello" + name + "!";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello" + name + "!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return " Hello " + user.getFirstName() + " " + user.getLastName() + "!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                           @RequestParam(value = "lastName", defaultValue = "avi") String lastName) {
        return " Hello " + firstName + " " + lastName + "!";
    }

    @GetMapping("/getGreetingData")
    public Greeting greeting(@RequestParam(value = "fName", defaultValue = "Ashvini") String fname,
                             @RequestParam(value = "lName", defaultValue = "Kanojia") String lname) {
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        return greetingServiceI.getGreetingInfo(user);
    }

    @GetMapping("/getGreetingById/{id}")
    public Greeting getGreetingCardById(@PathVariable Long id){
        return greetingServiceI.getGreetingbyId(id);
    }
}
