package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.person.Person;

@WebService
public interface ServiceExample {
	
    @WebMethod
    public Person getPersonById(@WebParam(name = "id") int id);
}
