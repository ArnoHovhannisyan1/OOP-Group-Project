package Products;

import java.awt.Image;

public abstract class Product
{    
    public String ProductId;
    public String ModelName;
    public String BrandName;
    public String Description; 
    public String Price; 
    public String Condition;
    public String Weight;
    public String Dimensions;
    public String Color; 
    public String ImagePath;
    public String DeviceType;


    public Product(String productID, String modelName, String brandName, String description, String price, String condition, 
                    String weight, String dimensions, String color, String imagepath)
                    {
                        this.ProductId = productID;
                        this.ModelName = modelName;
                        this.BrandName = brandName;
                        this.Description = description;
                        this.Price = price;
                        this.Condition = condition;
                        this.Weight = weight;
                        this.Dimensions = dimensions;
                        this.Color = color;
                        this.ImagePath = imagepath;
                    }



    public String getProductId()
    {
        return ProductId;
    }
    public String getModelName()
    {
        return ModelName;
    }
    public String getBrandName()
    {
        return BrandName;
    }
    public String getDescription()
    {
        return Description;
    }
    public String getPrice()
    {
        return Price;
    }
    public String getCondition()
    {
        return Condition;
    }
    public String getWeight()
    {
        return Weight;
    }
    public String getDimensions()
    {
        return Dimensions;
    }
    public String getColor()
    {
        return Color;
    }
    public String getImagePath()
    {
        return ImagePath;
    }

    // public enum Category
    // {
    //     SMARTHPHONE, 
    //     LAPTOP,
    //     TABLET,
    //     DESKTOPCOMPUTER,
    //     WEARABLE,
    //     GAMINGCONSOLE,
    //     SMARTHOMEDEVICE,
    //     CAMERA,
    //     AUIDOPLAYER
    // }

    // public enum Condition
    // {
    //     NEW,
    //     USED
    // }
}