package com.example.cab302project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MockGoalDAO {
    private Connection connection;

    public MockGoalDAO() {
        this.connection = SqliteConnection.getInstance();
        createTable();
    }

    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS goals ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "goalTitle VARCHAR NOT NULL, "
                    + "goalDetails VARCHAR NOT NULL)";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Save goalTitle and goalDetails to the database
    public void saveGoal(String goalTitle, String goalDetails) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO goals (goalTitle, goalDetails) VALUES (?, ?)"
            );
            statement.setString(1, goalTitle);
            statement.setString(2, goalDetails);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getAllGoals() {
        List<String[]> goals = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT goalTitle, goalDetails FROM goals");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("goalTitle");
                String details = rs.getString("goalDetails");
                goals.add(new String[]{title, details}); // Add the goal as an array
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goals;
    }
}
