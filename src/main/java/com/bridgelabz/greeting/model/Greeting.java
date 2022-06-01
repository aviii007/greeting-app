package com.bridgelabz.greeting.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Greeting {

    @Id
    private long id;
    private String message;

    public Greeting(long id, String message){
        this.id = id;
        this.message = message;

    }
    public Greeting(){
        id = 0;
        message = "";
    }
}
