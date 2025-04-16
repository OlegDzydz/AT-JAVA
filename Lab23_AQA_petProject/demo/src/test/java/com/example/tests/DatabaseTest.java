package com.example.tests;

import com.example.model.Address;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatabaseTest {
    @Test
    public void testOrmSaveAndLoad() {
        User u = new User();
        u.setUsername("dbuser");
        u.setEmail("db@example.com");
        Address a = new Address();
        a.setStreet("Main");
        a.setCity("Kyiv");
        a.setCountry("Ukraine");
        u.setAddress(a);

        UserRepository repo = new UserRepository();
        repo.save(u);

        User loaded = repo.findById(u.getId());
        Assert.assertEquals(loaded.getUsername(), "dbuser");
    }
}
