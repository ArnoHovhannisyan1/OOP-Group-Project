package Products;

public class Computer extends Product{
    private String Processor;
    private String Display;
    private String Ram;
    private String Storage;
    private String SystemType;
    private ComputerType ComputerType;
    


    public enum ComputerType
    {
        LAPTOP,
        PC
    }


}
