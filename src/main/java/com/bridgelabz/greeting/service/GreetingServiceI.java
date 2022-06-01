package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;

public interface GreetingServiceI {
    Greeting getGreetingInfo(User user);

    Greeting getGreetingbyId(Long id);
}
