package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamProcessor {

    public static List<Person> generateRandomPeople(int n) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(new Person(
                    "User" + i,
                    i % 2 == 0,
                    new Address("Street " + i, "City" + (i % 3), "State" + (i % 2))));
        }
        return people;
    }

    public static List<Person> process(List<Person> people) {
        return people.stream()
                .filter(p -> p.isEmployed() && p.getAddress().getCity().equals("City1"))
                .sorted(Comparator.comparing((Person p) -> p.getName()).thenComparing(p -> p.getAddress().getCity()))
                .collect(Collectors.toList());
    }
}
