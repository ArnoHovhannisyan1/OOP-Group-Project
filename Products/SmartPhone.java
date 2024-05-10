package Products;
public class SmartPhone extends Product{
    private String Memory;
    private String Display;

    public SmartPhone(String productID, String modelName, String brandName, String description, String price, String condition, 
    String weight, String dimensions, String color, String imagepath, String memory, String display)
    {
        super(productID,modelName,brandName,description,price,condition,weight,dimensions,color,imagepath);

        this.Memory = memory;
        this.Display = display;
    }

    public String getMemory()
    {
        return Memory;
    }
    public String getDisplay()
    {
        return Display;
    }

     //smth
}
