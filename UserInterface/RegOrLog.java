package UserInterface;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RegOrLog extends JFrame {

    public RegOrLog()
    {
        // setTitle("Inventory Management System");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // // Create login panel
        // JPanel loginPanel = new JPanel();
        // JLabel usernameLabel = new JLabel("Username:");
        // JTextField usernameField = new JTextField(20);

        // JLabel passwordLabel = new JLabel("Password:");
        // JPasswordField passwordField = new JPasswordField(20);
        
        // JButton loginButton = new JButton("Login");
        // JButton skipButton = new JButton("Skip");

        // // Add components to login panel
        // loginPanel.add(usernameLabel);
        // loginPanel.add(usernameField);
        // loginPanel.add(passwordLabel);
        // loginPanel.add(passwordField);
        // loginPanel.add(loginButton);
        // loginPanel.add(skipButton);

        // // Add login panel to the frame
        // add(loginPanel);

        // // Set size and center the window
        // setSize(400, 200);
        // setLocationRelativeTo(null);
        // setVisible(true);

        // // Event listener for skip button
        // skipButton.addActionListener(e -> {
        //     // If skip button is clicked, proceed to main window
        //     showMainWindow();
        // });

        // // Event listener for login button
        // loginButton.addActionListener(e -> {
        //     // Check username and password
        //     String username = usernameField.getText();
        //     String password = new String(passwordField.getPassword());

        //     // For simplicity, let's just print the username and password
        //     System.out.println("Username: " + username);
        //     System.out.println("Password: " + password);

        //     // If username and password are valid, proceed to main window
        //     showMainWindow();
        // });
        setTitle("Start Up Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with 10px horizontal and vertical gaps

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");
        JButton guestButton = new JButton("Continue as Guest");

        // Add buttons to the panel
        panel.add(registerButton);
        panel.add(loginButton);
        panel.add(guestButton);

        // Add panel to the frame
        add(panel);

        // Set size and center the window
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        // Add action listeners to the buttons
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration window
                openRegistrationWindow();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login window
                openLoginWindow();
            }
        });

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Proceed as guest (open the next window for guest)
                openNextWindowForGuest();
            }
        });

    }



 private void openRegistrationWindow() {
        // Close the current window and open the registration window
        dispose(); // Close the current window
        RegistrationUI registrationWindow = new RegistrationUI();
        registrationWindow.setVisible(true);
    }

    private void openLoginWindow() {
        // Close the current window and open the login window
        dispose(); // Close the current window
        LoginUI loginWindow = new LoginUI();
        loginWindow.setVisible(true);
    }

    private void openNextWindowForGuest() {
        // Close the current window and open the next window for guest
        dispose(); // Close the current window
        MainWindow guestMainWindow = new MainWindow(null);
        guestMainWindow.setVisible(true);
    }

    // private void showMainWindow() {
    //     // Close the login window and show the main window
    //     setVisible(false); // Hide login window
    //     // Create an instance of MainWindow (assuming you have another class for the main window)
    //     //MainWindow mainWindow = new MainWindow();
    //    // mainWindow.setVisible(true); // Show main window
    //}
}
