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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hakim
 */
public class SavingTest {
    
    @Test
    public void testHashCode() {
        Saving expectedSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ZERO);
        Saving testSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ZERO);
        
        Assert.assertTrue(testSaving.hashCode() == expectedSaving.hashCode());
    }
    
    @Test
    public void testHashCodeForASymmetric() { 
        Saving expectedSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ZERO);
        Saving testSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ONE);
        
        Assert.assertTrue(testSaving.hashCode() != expectedSaving.hashCode());
    }
    
    @Test
    public void testEquals() {
        Saving expectedSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ZERO);
        Saving testSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ZERO);
        
        Assert.assertTrue(testSaving.equals(expectedSaving));
    }
    
    @Test
    public void testEqualsASymmetric() {
        Saving expectedSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ZERO);
        Saving testSaving = new Saving("Tin O Beans", "Half Price", BigDecimal.ONE);
        
        Assert.assertTrue(!testSaving.equals(expectedSaving));
    }
}
