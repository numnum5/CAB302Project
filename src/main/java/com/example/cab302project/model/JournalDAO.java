package com.example.cab302project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JournalDAO {
    private Connection connection;

    public JournalDAO() {
        this.connection = SqliteConnection.getInstance();
        createTable();
    }

    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS journals ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "entry VARCHAR NOT NULL,"
                    + "mood VARCHAR NOT NULL,"
                    + "username VARCHAR NOT NULL"
                    + ")";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEntry(String entry, String mood, String userName) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO journals (entry, mood, username) VALUES (?, ?, ?)");
            statement.setString(1, entry);
            statement.setString(2, mood);
            statement.setString(3, userName);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllEntries(String userName) {
        List<String> entries = new ArrayList<>();
        String query = "SELECT entry, mood FROM journals WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the parameter in the query
            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String entry = resultSet.getString("entry");
                String mood = resultSet.getString("mood");
                entries.add("Mood: " + mood + "\nEntry: " + entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entries;
    }

}
