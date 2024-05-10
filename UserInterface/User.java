package UserInterface;
import java.util.ArrayList;
import java.util.List;

import Products.Product;

public class User {
    private int UserId;

    private String username; //first const
    private String password; //first const
    private boolean isAdmin;
    private List<Product> basket;
    private double balance;

    private String firstName;
    private String lastName;
    private String email;

    public User(){
        username = "Guest mode";
        password = null;
        isAdmin = false;
        basket = null;
        balance = 0;
        firstName = null;
        lastName = null;
        email = null;
    }



    public User(String username, String Password)
    {
        this.username = username;
        this.password = password;
        basket = new ArrayList<Product>();
                // add method setIsAdmin if admin
    }
    
    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public boolean getUserType()
    {
        return this.isAdmin;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void setBalance(double money)
    {
        balance = money;
    }

    public List<Product> getBasket()
    {
        return this.basket;
    }
    
    public void addToBasket(Product product)
    {
        basket.add(product);
    }

    public void setFirstName(String name)
    {
        this.firstName = name;
    }

    public String getFirtsName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }








    // public enum UserType{
    //     CLIENT,
    //     ADMIN
    // }

}
