package com.junit;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    private UserService userService;

    // Runs before each test — Arrange
    @Before
    public void setUp() {
        System.out.println("Setting up...");
        userService = new UserService();
        userService.addUser("Arjun");
    }

    // Runs after each test — Teardown
    @After
    public void tearDown() {
        System.out.println("Tearing down...");
        userService = null;
    }

    @Test
    public void testAddUser() {
        // Arrange
        String newUser = "Alice";

        // Act
        userService.addUser(newUser);

        // Assert
        assertTrue(userService.hasUser(newUser));
    }

    @Test
    public void testUserCount() {
        // Arrange
        String newUser = "Bob";

        // Act
        userService.addUser(newUser);

        // Assert
        assertEquals(2, userService.getUserCount());
    }

    @Test
    public void testRemoveUser() {
        // Arrange — "Arjun" already added in setUp()

        // Act
        userService.removeUser("Arjun");

        // Assert
        assertFalse(userService.hasUser("Arjun"));
    }
}