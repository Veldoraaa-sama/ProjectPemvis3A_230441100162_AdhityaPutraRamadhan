/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package w;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ADHITYAPUTRA
 */
public class DatabaseConnection {
     // Konfigurasi koneksi
    private static final String URL = "jdbc:mysql://localhost:3306/entertainment_app";
    private static final String USER = "root"; // Ganti dengan username database Anda
    private static final String PASSWORD = ""; // Ganti dengan password database Anda

    // Method untuk mendapatkan koneksi
    public static Connection getConnection() throws SQLException {
        try {
            // Register driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Kembali dengan koneksi ke database
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver tidak ditemukan: " + e.getMessage());
        }
    }
    
}
