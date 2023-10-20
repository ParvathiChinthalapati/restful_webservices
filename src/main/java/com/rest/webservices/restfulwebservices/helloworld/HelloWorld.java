package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello-world")
	public String printHelloWorld() {
		return "Hi! Welcome to Restful webservices";
		
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean printHelloWorldBean() {
		return new HelloWorldBean("Hi! Welcome to Restful webservices");
		
	}
	
	@GetMapping("/hello-world/pathVariable/{name}")
	public HelloWorldBean printHelloWorldPathVatiable(@PathVariable String name) {
		return new HelloWorldBean("Hi! Welcome to Restful webservices "+name);
		
	}
	
	@GetMapping("/hello-world-internationalization")
	public String printHelloWorldInternationalization() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("hello.message", null, "Defaut message", locale);
		
	}
}
