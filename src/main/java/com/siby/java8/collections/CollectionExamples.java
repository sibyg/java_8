package com.siby.java8.collections;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

class Student {
    private final Person person;

    Student(Person person) {
        this.person = person;
    }
}

public class CollectionExamples {
    public static void main(String... args) {
        List<Person> persons = asList(new Person("Joe", 18), new Person("Jim", 19), new Person("John", 12));

        // filter example
        List<Person> adults = persons.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());

        // map example
        List<Student> students = persons.stream()
                .filter(person -> person.getAge() > 18)
                .map(Student::new)
                .collect(Collectors.toList());

        // custom sort
        List<Person> sortedByName = persons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

        // search
        boolean anyoneWith18 = persons.stream().anyMatch(person -> person.getAge() == 18);

        // reduce operation
        Optional<String> concatenatedNames = persons.stream().map(p -> p.getName()).reduce((x, y) -> x + "#" + y);

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }


        map.forEach((id, val) -> System.out.println(val));
        map.computeIfPresent(3, (num, val) -> num+val);
        map.forEach((id, val) -> System.out.println(val));



    }
}
