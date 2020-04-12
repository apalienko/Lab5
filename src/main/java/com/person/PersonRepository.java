package com.person;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import java.util.function.Predicate;

/**
 *  Persons repository.
 */

@XmlRootElement(name = "personRepository")
public class PersonRepository  {
	
    private Person[] persons;

    private static final int DEFAULT_SIZE = 10;

    private int maxSize;

    private int currentSize = 0;

    public PersonRepository() {
        persons = new Person[DEFAULT_SIZE];
        maxSize = DEFAULT_SIZE;
    }

    public PersonRepository(final int size) {
        persons = new Person[size];
        maxSize = size;
    }

    /**
     * Constructor - creating a new object based on an array.
     * @param persons source array
     */
    public PersonRepository(Person[] persons) {
        this.persons = persons;
        maxSize = persons.length;
        currentSize = maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void add(Person person) {
        if (currentSize == maxSize) {
            increaseLength();
        }
        persons[currentSize] = person;
        currentSize++;
    }

    public void add(int index, Person person) {
        rangeCheck(index);
        if (currentSize == maxSize) {
            increaseLength();
        }
        for (int i = currentSize; i > index; i--) {
            persons[i] = persons[i - 1];
        }
        persons[index] = person;
        currentSize++;
    }

    public Person get(int index) {
        rangeCheck(index);
        return persons[index];
    }

    public Person set(int index, Person person) {
        rangeCheck(index);
        persons[index] = person;
        return person;
    }

    public Person delete(int index) {
        rangeCheck(index);
        Person person = persons[index];
        for (int i = index; i < currentSize - 1; i++) {
            persons[i] = persons[i + 1];
        }
        persons[--currentSize] = null;
        return person;
    }

    /**
     * Checks if the index is in the available range.
     * 
     * @param index to check
     */
    private void rangeCheck(int index) {
        if (index >= currentSize || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public PersonRepository searchBy(Predicate<Person> condition) {
        PersonRepository res = new PersonRepository();
        for (int i = 0; i < currentSize; i++) {
            if (condition.test(persons[i])) {
                res.add(persons[i]);
            }
        }
        return res;
    }

    private void increaseLength() {
        maxSize = (maxSize * 3) / 2 + 1;
        Person[] bigPersons = new Person[maxSize];
        System.arraycopy(persons, 0, bigPersons, 0, currentSize);
        persons = bigPersons;
    }

    /**
     * Converts the repository to List.
     * 
     * @return list of persons
     */
    public List<Person> toList() {
        return new ArrayList<>(Arrays.asList(persons));
    }

    /**
     * Compares two objects by persons.
     * 
     * @param o the compared object
     * @return true, if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRepository that = (PersonRepository) o;
        return Arrays.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(persons);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < currentSize; i++) {
            stringBuilder.append(persons[i].toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
