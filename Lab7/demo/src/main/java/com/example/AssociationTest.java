package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class AssociationTest {
    public static void main(String[] args) {
        // 1. Створимо об'єкти для зв'язків
        Address addr1 = new Address("123 Main St", "Seattle", "WA");
        Address addr2 = new Address("456 Oak Ave", "Portland", "OR");

        // Уявимо, що Mary і Alice живуть за addr1, John - за addr2
        Person mary = new Person("Mary", true);
        Person alice = new Person("Alice", true);
        Person john = new Person("John", false);

        mary.setAddress(addr1);
        alice.setAddress(addr1);
        john.setAddress(addr2);

        // OneToOne
        Passport passMary = new Passport("M-12345");
        mary.setPassport(passMary);
        passMary.setPerson(mary); // зворотній зв'язок

        // ManyToMany
        Project projA = new Project("ProjectA");
        Project projB = new Project("ProjectB");

        // Mary бере участь у двох проектах
        Set<Project> maryProjects = new HashSet<>();
        maryProjects.add(projA);
        maryProjects.add(projB);
        mary.setProjects(maryProjects);
        projA.getPersons().add(mary);
        projB.getPersons().add(mary);

        // Alice бере участь лише у ProjectB
        alice.getProjects().add(projB);
        projB.getPersons().add(alice);

        // 2. CREATE (збереження в БД)
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(addr1);
            session.save(addr2);

            // Завдяки CascadeType.ALL, можна було б зберегти лише person,
            // але для надійності показуємо збереження явно.
            session.save(projA);
            session.save(projB);

            session.save(mary);
            session.save(alice);
            session.save(john);

            tx.commit();
            System.out.println("CREATE: Усі об'єкти збережено.");
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // 3. READ & UPDATE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        try {
            Person loadedMary = session.get(Person.class, mary.getId());
            System.out.println("READ Mary: " + loadedMary);

            // Оновлення
            loadedMary.setName("Updated Mary");
            session.update(loadedMary);

            tx.commit();
            System.out.println("UPDATE: Змінили ім'я Mary на 'Updated Mary'");
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // 4. DELETE (наприклад, видалимо John)
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        try {
            Person loadedJohn = session.get(Person.class, john.getId());
            if (loadedJohn != null) {
                session.delete(loadedJohn);
                System.out.println("DELETE: Видалено John з id=" + loadedJohn.getId());
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
