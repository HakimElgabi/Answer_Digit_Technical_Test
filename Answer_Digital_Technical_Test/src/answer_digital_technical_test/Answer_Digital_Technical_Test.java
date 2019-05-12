/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;


public class Answer_Digital_Technical_Test {
        
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final Store store = new Store();

        System.out.println(parsingInputFile(store));
        
        Till till = new Till(store);
        
        System.out.print("To scan items, enter the product code one line at a time. Once finished type * : \n");
        
        while (true)
        {
            Scanner keyboard = new Scanner (System.in);
            String productCode;
            
            productCode = keyboard.next();
            
            if (productCode.equals("*"))
                break;
            else {
                if (!(till.scan(productCode))){
                    System.out.print("That Product Code doesn't exist, try again \n");
                }
            }
        }
        System.out.println(till.getReceipt().toString());
    }
    
    public static String parsingInputFile(Store store) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("testfile.txt"));
        
        String line;
        while((line = in.readLine()) != null)
        {
            final Sku sku = Sku.parseProduct(line);
            store.addSku(sku);
        }
        in.close();
        
        return store.toString();
    }
    
}
