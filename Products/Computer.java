package Products;
public class Computer extends Product{
    private String Processor;
    private String Display;
    private String Ram;
    private String Storage;
    private String SystemType;
    private String ComputerType;

    public Computer(String productID, String modelName, String brandName, String description, String price, String condition, 
    String weight, String dimensions, String color, String imagepath, String processor, String display, String ram, String storage,
    String systemType, String computerType)
    {
        super( productID,  modelName,  brandName,  description,  price,  condition, 
         weight,  dimensions,  color,  imagepath);
         this.Processor = processor;
         this.Display = display;
         this.Ram = ram;
         this.Storage = storage;
         this.SystemType = systemType;
         this.ComputerType = computerType;
    }
    


    // public enum ComputerType
    // {
    //     LAPTOP,
    //     PC
    // }


}
