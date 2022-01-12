package groceries;

import java.io.*;
import java.util.Scanner;

/**
 * Practice reading and writing to a file.
 * 
 * @author Megan Rigsbee (mrigsbee0
 * @version 2015.03.24
 */
public class FileIO {
    

    
    
    /**
     * Reads groceries from a file and adds them to a GroceryBag object,
     * the writes the groceries back to a file using GroceryBag's
     * toString method.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        
        
        try 
        {
            File grocerylist = new File("grocerylist.txt");
            GroceryBag bag = new GroceryBag();
            Scanner scan = new Scanner(grocerylist);
            
            while(scan.hasNext())
            {
                bag.add(scan.next());
            }
            
            scan.close();
            
            PrintWriter write = new PrintWriter("output.txt");
            write.print(bag.toString());
            write.close();
                        
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("Scanner error opening the file ");
            System.out.println(e.getMessage());
        }
    }
}
