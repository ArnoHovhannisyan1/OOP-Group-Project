package UserInterface;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginUI extends JFrame
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    public LoginUI()
    {
        setTitle("Inventory Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create login panel
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        
        JButton loginButton = new JButton("Login");
        JButton backToButton = new JButton("Back to menu");


        // Add components to login panel
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(backToButton);


        // Add login panel to the frame
        add(loginPanel);

        // Set size and center the window
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);


        // Event listener for login button
        // registerButton.addActionListener(e -> {
        //     // Check username and password
        //     String username = usernameField.getText();
        //     String password = new String(passwordField.getPassword());

        //     // For simplicity, let's just print the username and password
        //     System.out.println("Username: " + username);
        //     System.out.println("Password: " + password);

        //     // If username and password are valid, proceed to main window
        //     //showMainWindow();
        // });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });

        backToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToMenu();
            }
        });

        
    }
        
        private void loginUser() {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
    
            // Read user database from text file
            try (BufferedReader reader = new BufferedReader(new FileReader("user_database.txt"))) {
                String line;
                boolean loggedIn = false;
    
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                        loggedIn = true;
                        break;
                    }
                }
    
                if (loggedIn) {
                    //JOptionPane.showMessageDialog(this, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    MainWindow nextPage = new MainWindow(new User(username, password));
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to read user database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }





        private void backToMenu()
        {
            this.dispose();
            RegOrLog backtomenu = new RegOrLog();
            backtomenu.setVisible(true);
        }
    
    
}
