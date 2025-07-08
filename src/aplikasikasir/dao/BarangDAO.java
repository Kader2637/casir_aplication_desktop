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
import aplikasikasir.model.Barang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS barang ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nama TEXT NOT NULL,"
                + "kode TEXT NOT NULL UNIQUE,"
                + "stok INTEGER,"
                + "harga TEXT,"
                + "deskripsi TEXT)";
        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Gagal membuat tabel barang: " + e.getMessage());
        }
    }

    public static boolean insertBarang(Barang barang) {
        String sql = "INSERT INTO barang (nama, kode, stok, harga, deskripsi) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, barang.getNama());
            ps.setString(2, barang.getKode());
            ps.setInt(3, barang.getStok());
            ps.setString(4, barang.getHarga());
            ps.setString(5, barang.getDeskripsi());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan barang: " + e.getMessage());
            return false;
        }
    }

    public static boolean updateBarang(Barang barang, String kodeLama) {
        String sql = "UPDATE barang SET nama=?, kode=?, stok=?, harga=?, deskripsi=? WHERE kode=?";
        try (Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, barang.getNama());
            ps.setString(2, barang.getKode());
            ps.setInt(3, barang.getStok());
            ps.setString(4, barang.getHarga());
            ps.setString(5, barang.getDeskripsi());
            ps.setString(6, kodeLama);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Gagal update: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteBarang(String kode) {
        String sql = "DELETE FROM barang WHERE kode = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kode);
            int affected = ps.executeUpdate();
            if (affected == 0) {
                System.out.println("Tidak ada data dengan kode: " + kode + " yang dihapus.");
            }
            return affected > 0;
        } catch (SQLException e) {
            System.err.println("Gagal menghapus barang dengan kode " + kode);
            e.printStackTrace();
            return false;
        }
    }

    public static List<Barang> getAllBarang() {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";

        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Barang barang = new Barang(
                        rs.getString("nama"),
                        rs.getString("kode"),
                        rs.getInt("stok"),
                        rs.getString("harga"),
                        rs.getString("deskripsi")
                );
                list.add(barang);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data barang: " + e.getMessage());
        }

        return list;
    }

    public static Barang getBarangByKode(String kode) {
        String sql = "SELECT * FROM barang WHERE kode = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Barang(
                        rs.getString("nama"),
                        rs.getString("kode"),
                        rs.getInt("stok"),
                        rs.getString("harga"),
                        rs.getString("deskripsi")
                );
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil barang: " + e.getMessage());
        }
        return null;
    }

    public static void kurangiStok(String kode, int jumlah) {
        String sql = "UPDATE barang SET stok = stok - ? WHERE kode = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, jumlah);
            ps.setString(2, kode);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal mengurangi stok: " + e.getMessage());
        }
    }
}
