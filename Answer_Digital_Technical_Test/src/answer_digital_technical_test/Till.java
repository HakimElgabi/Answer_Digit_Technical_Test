/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import java.util.ArrayList;
import java.util.Objects;

public class Till {
    
    private ArrayList<Sku> basket = new ArrayList<Sku>();
    private Store store;    
    
    public Till (Store store){
        this.store = store;
    }
    
    public boolean scan(String productCode){
        Sku scannedProduct = new Sku();
        scannedProduct = store.getSku(productCode);
        
        if (scannedProduct != null){
            basket.add(scannedProduct);
            return true;
        }
        else
            return false;
    }
    
    public Receipt getReceipt(){
        Receipt receipt = new Receipt(basket);
        return receipt;
    }
    
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < basket.size(); i++){
            output = output + basket.get(i).toString();
        }
        return "Product Code" + "\t" + "Description" + "\t" + "Price" + "\n" + output;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        
        if (!(o instanceof Till)) {
            return false;
        }

        Till till = (Till) o;

        return Objects.equals(basket, till.basket) && 
                Objects.equals(store, till.store);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(basket, store);
    }

}
