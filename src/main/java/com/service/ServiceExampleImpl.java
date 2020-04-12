package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.person.Person;
import com.person.PersonRepository;

import java.math.BigDecimal;

@WebService(endpointInterface = "com.service.ServiceExample", serviceName = "ServiceExampleImpl")
public class ServiceExampleImpl implements ServiceExample {
    PersonRepository repository;

    public ServiceExampleImpl() {
        repository = new PersonRepository();
        repository.add(new Person(1, "Александр", "Пупкин", BigDecimal.ZERO));
        repository.add(new Person(2, "Генадий", "Иванов", BigDecimal.ZERO));
        repository.add(new Person(3, "Иван", "Смирнов", BigDecimal.ZERO));
        repository.add(new Person(4, "Кирилл", "Керенский", BigDecimal.ZERO));
        repository.add(new Person(5, "Сергей", "Сэргеев", BigDecimal.ZERO));
        repository.add(new Person(6, "Дмитрий", "Семенов", BigDecimal.ZERO));
    }

    @Override
    @WebMethod
    public Person getPersonById(@WebParam(name = "id") int id) {
        PersonRepository resultRep = repository.searchBy(x -> x.getId() == id);
        return resultRep.getCurrentSize() == 0 ? null : resultRep.get(0);
    }
}
