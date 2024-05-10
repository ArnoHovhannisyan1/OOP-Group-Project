package UserInterface;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationUI extends JFrame
{
    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegistrationUI()
    {
        setTitle("Inventory Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create login panel
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        
        JButton registerButton = new JButton("Register");
        JButton backToButton = new JButton("Back to menu");

        // Add components to login panel
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(registerButton);
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
        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        backToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToMenu();
            }
        });
    }



    
    // private void registerUser() {
    //     String username = usernameField.getText();
    //     String password = new String(passwordField.getPassword());

    //     // Check if username or password is empty
    //     if (username.isEmpty() || password.isEmpty()) {
    //         JOptionPane.showMessageDialog(this, "Please enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
    //         return;
    //     }

    //     // Write username and password to text file
    //     try (FileWriter writer = new FileWriter("user_database.txt", true)) {
    //         writer.write(username + ":" + password + "\n");
    //         JOptionPane.showMessageDialog(this, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
    //         clearFields();
    //         writer.close();
    //     } catch (IOException ex) {
    //         ex.printStackTrace();
    //         JOptionPane.showMessageDialog(this, "Failed to register user", "Error", JOptionPane.ERROR_MESSAGE);
    //     }
    // }
    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
    
        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Write username and password to text file
        try (FileWriter writer = new FileWriter("user_database.txt", true)) {
            writer.write(username + ":" + password + "\n");
            writer.flush(); // Flush the stream to ensure data is written immediately
            JOptionPane.showMessageDialog(this, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            openLoginUI();
            clearFields();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to register user", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }


    private void openLoginUI()
    {
        this.dispose();
        LoginUI loginWindow = new LoginUI();
            loginWindow.setVisible(true);
    }

    
    private void backToMenu()
    {
        this.dispose();
        RegOrLog backtomenu = new RegOrLog();
       backtomenu.setVisible(true);

    }



}
