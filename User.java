public abstract class User {
    public int UserId;
    public String Username; 
    public String Password;
    public String FirstName;
    public String LastName;
    public String Email;
    public UserType UserType;
    

    public enum UserType{
        CLIENT,
        ADMIN
    }

}
