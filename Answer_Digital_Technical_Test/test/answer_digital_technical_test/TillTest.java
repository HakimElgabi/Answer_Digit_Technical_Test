/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class TillTest {
    private static Store testStore = new Store();
    
    final static Sku testSku1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
    final static Sku testSku2 = new Sku("C330", "Fruity Drink", "", new BigDecimal("0.54"), null);
    final static Sku testSku3 = new Sku("BR7", "Sliced Loaf", "", new BigDecimal("1.54"), null); 

    @BeforeClass
    public static void setUpClass() { 
        testStore.addSku(testSku1);
        testStore.addSku(testSku2);
        testStore.addSku(testSku3);
    }
    
    @Test
    public void testScanProductCode() {        
        Till testTill = new Till(testStore);
        
        boolean testScan = testTill.scan("H57");
        
        Assert.assertEquals(testScan, true);
    }
    
    @Test
    public void testScanInvalidProductCode() {        
        Till testTill = new Till(testStore);
        
        boolean testScan = testTill.scan("H57bb");
        
        Assert.assertEquals(testScan, false);
    }
    
    @Test
    public void testGetReceipt() {        
        Till testTill = new Till(testStore);
        
        // Creating an expected basket
        ArrayList<Sku> expectedBasket = new ArrayList<Sku>();
        expectedBasket.add(testSku1);
        // Creating an expected receipt
        Receipt expectedReceipt = new Receipt(expectedBasket);
        
        // Scan item to add to test till which will add to the receipt
        testTill.scan("H57");
        
        Assert.assertEquals(testTill.getReceipt(), expectedReceipt);
    }
    
    @Test
    public void testHashCode() {
        Till testTill1 = new Till(testStore);
        Till testTill2 = new Till(testStore);
        
        Assert.assertTrue(testTill1.hashCode() == testTill2.hashCode());
    }
    
    @Test
    public void testHashCodeForASymmetric() { 
        Till testTill1 = new Till(testStore);
        
        Store testStore2 = new Store();
        
        testStore2.addSku(testSku1);
        testStore2.addSku(testSku2);
        
        Till testTill2 = new Till(testStore2);
        
        Assert.assertTrue(testTill1.hashCode() != testTill2.hashCode());
    }
    
    @Test
    public void testEquals() {
        Till testTill1 = new Till(testStore);
        Till testTill2 = new Till(testStore);
        
        Assert.assertTrue(testTill1.equals(testTill2));
    }
    
    @Test
    public void testEqualsASymmetric() {
        Till testTill1 = new Till(testStore);
        
        Store testStore2 = new Store();
        
        testStore2.addSku(testSku1);
        testStore2.addSku(testSku2);
        
        Till testTill2 = new Till(testStore2);
        
        Assert.assertTrue(!testTill1.equals(testTill2));
    }
}
