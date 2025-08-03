package com.pages;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBValidate {

	public static void main(String[] args) throws SQLException {
		
	
		try {
            // Step 1: Connect to H2 in-memory DB
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            java.sql.Statement stmt = conn.createStatement();

            // Step 2: Create table & insert data (like API would do)
            stmt.execute("CREATE TABLE accounts(id INT PRIMARY KEY, balance INT)");
            stmt.execute("CREATE TABLE users(id INT PRIMARY KEY, name VARCHAR(50))");

            // ✅ Step 3: Insert test data
            stmt.execute("INSERT INTO accounts VALUES(1, 5000)");
            stmt.execute("INSERT INTO users VALUES(1, 'Ramesh')");

            // ✅ Step 4: Query balance before update
            ResultSet rs = stmt.executeQuery("SELECT balance FROM accounts WHERE id = 1");
            if (rs.next()) {
                System.out.println("💰 Balance before update: " + rs.getInt("balance"));
            }

            // ✅ Step 5: Update balance
            stmt.execute("UPDATE accounts SET balance = 7000 WHERE id = 1");

            // ✅ Step 6: Validate user exists
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM users WHERE id = 1");
            if (rs1.next()) {
                System.out.println("✅ User found: " + rs1.getString("name"));
            } else {
                System.out.println("❌ User not found.");
            }

            // ✅ Step 7: Check updated balance
            ResultSet rs2 = stmt.executeQuery("SELECT balance FROM accounts WHERE id = 1");
            if (rs2.next()) {
                System.out.println("💰 Balance after update: " + rs2.getInt("balance"));
            }

            // Clean up
            rs.close();
            rs1.close();
            rs2.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

		}
	


