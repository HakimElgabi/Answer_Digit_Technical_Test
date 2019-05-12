/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Store {
    
    private ArrayList<Sku> skuList = new ArrayList<Sku>();

    public Store(){
        
    }
    
    public Store(ArrayList<Sku> skuList){
        this.skuList = skuList;
    }
    
    public void addSku(Sku sku) {
        this.skuList.add(sku);
    }
    
    public Sku getSku(String productCode) {
        for (Sku sku : this.skuList) {
            if (sku.getProductCode().equals(productCode.toUpperCase()))
                return sku;
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        String output = "";
        for (Sku sku : this.skuList) {
            output += sku.toString();
        }
        return "Product Code" + "\t" + "Description" + "\t" + "Price" + "\t" + "Offer" + "\n" + output;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        
        if (!(o instanceof Store)) {
            return false;
        }

        Store store = (Store) o;

        return Objects.equals(skuList, store.skuList);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(skuList);
    }
}
