package com.example.cab302project.model;


import java.util.List;

/**
 * Interface for the Contact Data Access Object that handles
 * the CRUD operations for the User class with the database.
 */
public interface IUserDAO {

    /**
     * Adds a new user to the database.
     * @param user The user to add.
     */
    public void addUser(User user);
    /**
     * Updates an existing user in the database.
     * @param user The user to update.
     */
    public void updateUser(User user);
    /**
     * Deletes a user from the database.
     * @param user The user to delete.
     */
    public void deleteUser(User user);
    /**
     * Retrieves a contact from the database.
     * @param id The id of the user to retrieve.
     * @return The user with the given id, or null if not found.
     */
    public int searchUser(String username, String password);

    /**
     * Retrieves a contact from the database.
     * @param id The id of the user to retrieve.
     * @return The user with the given id, or null if not found.
     */
    public User getUser(int id);
    /**
     * Retrieves all contacts from the database.
     * @return A list of all users in the database.
     */
    public List<User> getAllUsers();
}
