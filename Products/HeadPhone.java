package Products;

//import Products.HeadPhone.HeadPhoneType;

public class HeadPhone extends Product {
    private String Battery;
    private String HeadPhoneType;

    public HeadPhone(String productID, String modelName, String brandName, String description, String price, String condition, 
    String weight, String dimensions, String color, String imagepath, String battery, String headPhoneType)
    {
        super( productID,  modelName,  brandName,  description,  price,  condition, 
         weight,  dimensions,  color,  imagepath);
         this.Battery = battery;
         this.HeadPhoneType = headPhoneType;
    }



    // public enum HeadPhoneType
    // {
    //     WIRELESS,
    //     WIRED
    // }
}
   