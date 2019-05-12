/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import static answer_digital_technical_test.TillTest.testSku1;
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
public class ReceiptTest {
    
    private static ArrayList<Sku> expectedSkuList = new ArrayList<Sku>();
    private static ArrayList<Sku> expectedSkuList2 = new ArrayList<Sku>();
    
    private ArrayList<Saving> expectedSavings = new ArrayList<Saving>();
    
    
    final static Sku testSku1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
    final static Sku testSku2 = new Sku("C330", "Fruity Drink", "", new BigDecimal("0.54"), null);

    @BeforeClass
    public static void setUpClass() { 
        expectedSkuList.add(testSku1);
        
        expectedSkuList2.add(testSku1);
        expectedSkuList2.add(testSku2);
    }
    
    @Test
    public void testHashCode() {
        Receipt testReceipt1 = new Receipt(expectedSkuList);
        Receipt testReceipt2 = new Receipt(expectedSkuList);
        
        Assert.assertTrue(testReceipt1.hashCode() == testReceipt2.hashCode());
    }
    
    @Test
    public void testHashCodeForASymmetric() { 
        Receipt testReceipt1 = new Receipt(expectedSkuList);
        Receipt testReceipt2 = new Receipt(expectedSkuList2);
        
        Assert.assertTrue(testReceipt1.hashCode() != testReceipt2.hashCode());
    }
    
    @Test
    public void testEquals() {
        Receipt testReceipt1 = new Receipt(expectedSkuList);
        Receipt testReceipt2 = new Receipt(expectedSkuList);
        
        Assert.assertTrue(testReceipt1.equals(testReceipt2));
    }
    
    @Test
    public void testEqualsASymmetric() {
        Receipt testReceipt1 = new Receipt(expectedSkuList);
        Receipt testReceipt2 = new Receipt(expectedSkuList2);
        
        Assert.assertTrue(!testReceipt1.equals(testReceipt2));
    }
}
