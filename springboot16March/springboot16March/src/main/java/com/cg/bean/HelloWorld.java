package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

public String sayHello(String name) {
	// TODO Auto-generated method stub
	return "Hello " + name;
}
}
