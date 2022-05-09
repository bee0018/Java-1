package edu.auburn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:db/Test.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery("select * from Student");

            while (rs.next()) {
                System.out.println("ID = " + rs.getString("ID"));
                System.out.println("FirstName = " + rs.getString("FirstName"));
                System.out.println("LastName = " + rs.getString("LastName"));
                System.out.println("Age = " + rs.getInt("Age"));
                System.out.println("Phone = " + rs.getString("PhoneNumber") + "\n");
            }
        }
        catch (Exception e) {
//
        }
    }
}
