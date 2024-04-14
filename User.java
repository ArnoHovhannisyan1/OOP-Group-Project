public abstract class User {
    public int UserId;
    public String Username; 
    public String Password;
    public String FirstName;
    public String LastName;
    public String Email;
    

    public class UserNotFoundException extends Exception
    {
        UserNotFoundException()
        {
            super();
        }
        UserNotFoundException(String message)
        {
            super(message);
        }
    }

}
