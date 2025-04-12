package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CrudTest {

    public static void main(String[] args) {

        // --- CREATE ---
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Створюємо кілька записів у таблиці address
            Address addr1 = new Address("123 Main St", "Seattle", "WA");
            Address addr2 = new Address("456 Oak Ave", "Portland", "OR");

            session.save(addr1);
            session.save(addr2);

            // Створюємо кілька записів у таблиці person, посилаючись на Address
            Person p1 = new Person("Mary", true, addr1);
            Person p2 = new Person("John", false, addr2);
            Person p3 = new Person("Alice", true, addr1);

            session.save(p1);
            session.save(p2);
            session.save(p3);

            tx.commit();
            System.out.println("CREATE: Записи збережено.");
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // --- READ & UPDATE ---
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        try {
            // Читання всіх записів з таблиці Person
            List<Person> persons = session2.createQuery("FROM Person", Person.class).list();
            for (Person p : persons) {
                System.out.println("READ: " + p);
            }

            // Оновлення: змінюємо ім'я першої особи
            if (!persons.isEmpty()) {
                Person personToUpdate = persons.get(0);
                personToUpdate.setName("Updated " + personToUpdate.getName());
                session2.update(personToUpdate);
                System.out.println("UPDATE: Оновлено запис: " + personToUpdate);
            }

            tx2.commit();
        } catch (Exception e) {
            if (tx2 != null)
                tx2.rollback();
            e.printStackTrace();
        } finally {
            session2.close();
        }

        // --- DELETE ---
        Session session3 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = session3.beginTransaction();
        try {
            // Видалимо запис з id = 1 (як приклад)
            Person personToDelete = session3.get(Person.class, 1);
            if (personToDelete != null) {
                session3.delete(personToDelete);
                System.out.println("DELETE: Видалено запис з id=1");
            }
            tx3.commit();
        } catch (Exception e) {
            if (tx3 != null)
                tx3.rollback();
            e.printStackTrace();
        } finally {
            session3.close();
        }

        // Закриваємо SessionFactory
        HibernateUtil.getSessionFactory().close();
    }
}
