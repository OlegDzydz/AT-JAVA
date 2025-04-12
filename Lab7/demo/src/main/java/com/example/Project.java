package com.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Зворотний бік ManyToMany
    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<Person> persons = new HashSet<>();

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    // getters, setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Project[id=" + id + ", name=" + name + "]";
    }
}
