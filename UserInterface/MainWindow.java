package UserInterface;

// import javax.swing.DefaultListModel;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JList;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTextField;
// import javax.swing.SwingUtilities;

import javax.swing.*;

import Products.Product;
import Products.SmartPhone;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainWindow extends JFrame
{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel userInfoPanel;
    private JPanel productListPanel;
    private User theUser;
    private String usersInitialBasketCount = "0";
    JLabel userCurrentBasket;
    private String deviceType = "Smartphone";
    private String the_brandName ="Apple";
    private String the_condition = "new";
    ArrayList<Product> products = loadProductsFromFile("product_database.txt");



    public MainWindow(User user) {

        if(user != null)
            this.theUser = user;
        else
        theUser = new User();



        setTitle("Product List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());

        // Top panel with dropdowns
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // Add dropdowns to topPanel as needed
        topPanel.add(new JLabel("Device Type"));
        JComboBox<String> devTypes = new JComboBox<>(new String[]{"Smartphones", "Headphones", "Computers"});
        devTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                deviceType = (String) combo.getSelectedItem();
                products =  loadProductsFromFile("product_database.txt");
                loadProducts();
            }
        });
        topPanel.add(devTypes);



        topPanel.add(new JLabel("Condition"));
        JComboBox<String> cond = new JComboBox<>(new String[]{"New", "Used"});
        cond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>)e.getSource();
                the_condition = (String)combo.getSelectedItem();
                products =  loadProductsFromFile("product_database.txt");
                loadProducts();
            }
        });
        topPanel.add(cond);
       // setVisible(true);



        topPanel.add(new JLabel("Barnd Name"));
        JComboBox<String> brand = new JComboBox<>(new String[]{"Apple", "Windows", "Linux", "Android"});
        brand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>)e.getSource();
                the_brandName = (String) combo.getSelectedItem();
                products =  loadProductsFromFile("product_database.txt");
                loadProducts();
            }
        });
        topPanel.add(brand);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // User information panel
        userInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userInfoPanel.add(new JLabel(theUser.getUsername()));
        ImageIcon waitA = new ImageIcon("UIElements\\ShoppingCart.jpg");
        Image moment = waitA.getImage();
        Image aa = moment.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon shoppingCartIcon = new ImageIcon(aa);
        userCurrentBasket = new JLabel((theUser.getBasket() != null)? (theUser.getBasket().size()+"") : "0", shoppingCartIcon, SwingConstants.LEFT);
        userInfoPanel.add(userCurrentBasket);
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration window
                dispose();
                RegOrLog backto = new RegOrLog();
            }
        });
        userInfoPanel.add(logoutButton);
        mainPanel.add(userInfoPanel, BorderLayout.SOUTH);

        // Product list panel
        productListPanel = new JPanel();
        productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.Y_AXIS));
      
        loadProducts();
        mainPanel.add(productListPanel);
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);

        // Set size and center the window
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
}



    private void loadProducts(){
        for (Product product : products) {

            JPanel productPanel = new JPanel(new BorderLayout());
            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    
    
            // Image panel
            JPanel imagePanel = new JPanel(new BorderLayout());
    
                ImageIcon imageIcon = new ImageIcon(product.getImagePath());
                Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                JLabel imageLabel = new JLabel(scaledIcon);
                
            imagePanel.add(imageLabel, BorderLayout.CENTER);
            productPanel.add(imagePanel, BorderLayout.WEST);
    
             JPanel detailsPanel = new JPanel(new GridLayout(0, 1));
             JLabel modelName = new JLabel(product.getModelName());
             JLabel price = new JLabel(product.getPrice());
             JButton addButton = new JButton("Add to basket");
             addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    theUser.addToBasket(product);
                    userCurrentBasket.setText((theUser.getBasket() != null)? (theUser.getBasket().size()+"") : "0");
                }
            });
             JButton button2 = new JButton("Button 2");
             detailsPanel.add(modelName);
             detailsPanel.add(price);
             detailsPanel.add(addButton);
             detailsPanel.add(button2);
             productPanel.add(detailsPanel, BorderLayout.CENTER);
    
            productListPanel.add(productPanel);
        }
    }



     private ArrayList<Product> loadProductsFromFile(String filePath) {
        ArrayList<Product> products = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                
                if (parts.length == 14)
                {
                    String productID = parts[0];
                    String modelName = parts[1];
                    String brandName = parts[2];
                    String description = parts[3];
                    String price = parts[4];
                    String condition = parts[5];
                    String weight = parts[6];
                    String dimensions = parts[7];
                    String color = parts[8];
                    String memory = parts[9];
                    String display = parts[10];
                    String imagepath = parts[11];
                    if(brandName.equals(the_brandName) && condition.equals(the_condition) && description.equals(deviceType))
                    products.add(new SmartPhone(productID, modelName, brandName, description, price, condition, weight, dimensions, color, imagepath, memory, display));
                }

            
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load product information", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return products;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           // new MainWindow();
        });
    }
}
