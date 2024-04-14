
public abstract class  Product
{    
    public int ProductId;
    public String ModelName;
    public String BrandName;
    public String Description; 
    public Double Price; 
    public Condition Condition;
    public Double Weight;
    public String Dimensions;
    public Color Color;


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

    public enum Condition
    {
        NEW,
        USED
    }
}