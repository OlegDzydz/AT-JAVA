package com.example;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String number;

    // Зворотний зв'язок (опційно)
    @OneToOne(mappedBy = "passport")
    private Person person;

    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    // getters, setters
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Passport [id=" + id + ", number=" + number + "]";
    }
}
