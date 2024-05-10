import java.util.Scanner;
import javax.swing.*;

import UserInterface.RegOrLog;

public class Main extends JFrame
{
    public static void main(String[] args)
    {
        
        SwingUtilities.invokeLater(() -> {
            new RegOrLog();
        });
        
    }
}