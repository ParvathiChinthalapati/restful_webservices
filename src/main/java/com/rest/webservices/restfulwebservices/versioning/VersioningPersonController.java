package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPersion() {
		return new PersonV1("Siva Parvathi");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPersion() {
		return new PersonV2(new Name("Siva","Parvathi"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersionRequestParam() {
		return new PersonV1("Siva Parvathi");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersionRequestParam() {
		return new PersonV2(new Name("Siva","Parvathi"));
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersionRequestHeader() {
		return new PersonV1("Siva Parvathi");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersionRequestHeader() {
		return new PersonV2(new Name("Siva","Parvathi"));
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersionAcceptHeader() {
		return new PersonV1("Siva Parvathi");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersionAcceptHeader() {
		return new PersonV2(new Name("Siva","Parvathi"));
	}
}
