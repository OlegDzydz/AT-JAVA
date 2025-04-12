package com.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Якщо в таблиці person є стовпець "is_employed"
    @Column(name = "is_employed")
    private boolean employed;

    // ManyToOne: один Address може мати багато Person
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    // OneToOne: особа має один Passport
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    // ManyToMany: особа може брати участь у багатьох проектах
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_project", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();

    // Конструктор за замовчуванням
    public Person() {
    }

    // Конструктор із двома параметрами
    public Person(String name, boolean employed) {
        this.name = name;
        this.employed = employed;
    }

    // Додатковий конструктор із трьома параметрами
    public Person(String name, boolean employed, Address address) {
        this.name = name;
        this.employed = employed;
        this.address = address;
    }

    // Геттери
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEmployed() {
        return employed;
    }

    public Address getAddress() {
        return address;
    }

    public Passport getPassport() {
        return passport;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    // Сеттери
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Person[id=" + id +
                ", name=" + name +
                ", employed=" + employed +
                ", address=" + (address != null ? address.getId() : "null") +
                ", passport=" + (passport != null ? passport.getNumber() : "null") +
                ", projects=" + projects +
                "]";
    }
}
