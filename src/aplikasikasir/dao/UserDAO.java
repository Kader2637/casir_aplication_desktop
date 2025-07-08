/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasikasir.dao;

/**
 *
 * @author LEGION
 */

import aplikasikasir.config.Database;
import aplikasikasir.model.User;
import java.sql.*;

public class UserDAO {
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "username TEXT NOT NULL UNIQUE,"
                   + "password TEXT NOT NULL)";
        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Gagal membuat tabel user: " + e.getMessage());
        }
    }

    public static void insertDefaultUser() {
        String sql = "INSERT OR IGNORE INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "admin");
            ps.setString(2, "1234");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert user gagal: " + e.getMessage());
        }
    }

    public static boolean login(User user) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }
}

