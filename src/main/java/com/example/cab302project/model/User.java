package com.example.cab302project.model;


// Class for modeling a user
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String username;

    // Constructor for creating a new User object
    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
    }


    // Getters and setters for private fields
    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
