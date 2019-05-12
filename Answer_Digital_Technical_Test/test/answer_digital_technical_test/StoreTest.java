/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hakim
 */
public class StoreTest { 
    @Test
    public void testHashCode() {
        final Sku testSku = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        
        Store testStore1 = new Store();
        Store testStore2 = new Store();
        
        testStore1.addSku(testSku);
        testStore2.addSku(testSku);
        
        Assert.assertTrue(testStore1.hashCode() == testStore2.hashCode());
    }
    
    @Test
    public void testHashCodeForASymmetric() {
        final Sku testSku1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null);
        final Sku testSku2 = new Sku("C330", "Fruity Drink", "", new BigDecimal("0.54"), null); 
        
        Store testStore1 = new Store();
        Store testStore2 = new Store();
        
        testStore1.addSku(testSku1);
        testStore2.addSku(testSku2);
        
        Assert.assertTrue(testStore1.hashCode() != testStore2.hashCode());
    }
    
    @Test
    public void testEquals() {
        final Sku testSku = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        
        Store testStore1 = new Store();
        Store testStore2 = new Store();
        
        testStore1.addSku(testSku);
        testStore2.addSku(testSku);
        
        Assert.assertTrue(testStore1.equals(testStore2));
    }
    
    @Test
    public void testEqualsASymmetric() {
        final Sku testSku1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null);
        final Sku testSku2 = new Sku("C330", "Fruity Drink", "", new BigDecimal("0.54"), null); 
        
        Store testStore1 = new Store();
        Store testStore2 = new Store();
        
        testStore1.addSku(testSku1);
        testStore2.addSku(testSku2);
        
        Assert.assertTrue(!testStore1.equals(testStore2));
    }
}
