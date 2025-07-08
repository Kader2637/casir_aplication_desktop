/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplikasikasir;

/**
 *
 * @author LEGION
 */

import javax.swing.JFrame;
import aplikasikasir.dao.UserDAO;
import aplikasikasir.dao.BarangDAO;
import aplikasikasir.view.Login;

public class Main {
    public static void main(String[] args) {
        UserDAO.createTable();
        UserDAO.insertDefaultUser();
        BarangDAO.createTable();

        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame loginFrame = new JFrame("Login Aplikasi Kasir");
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setContentPane(new Login()); 
            loginFrame.setSize(1000, 500);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setVisible(true);
        });
    }
}

