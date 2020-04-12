package com.person;

import java.math.BigDecimal;
import java.util.Objects;

import javax.xml.bind.annotation.*;

/**
 * Person entity.
 */
@XmlRootElement(name = "person")
public class Person{
	
    private int id;

    private String firstName;

    private String secondName;

    private BigDecimal salary;

    /**
     * Constructor - creating an empty object.
     */
    public Person() {}

    /**
     * Constructor - creating a new object with parameters.
     * 
     * @param id id
     * @param firstName first name
     * @param secondName second name
     * @param salary salary
     */
    public Person(final Integer id, final String firstName,
                  final String secondName,
                  final BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;;
        this.salary = salary;
    }

    public static Person createEmptyPerson() {
        return new Person(0, "", "", BigDecimal.ZERO);
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return secondName;
    }

    public void setLastName(final String secondName) {
        this.secondName = secondName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * Compares two objects by id.
     * @param o the compared object
     * @return true, if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[ID = " + id + ", Имя = " + firstName + ", Фамилия = "
                + secondName + ", Зарплата = " + salary + "]";
    }
}
