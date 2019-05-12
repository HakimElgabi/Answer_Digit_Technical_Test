
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
public class SkuTest {
    
    @Test
    public void testParseProduct() {
        String skuDetails = "H57\tTin O Beans\t1.23";
        
        final Sku expectedSku = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        final Sku testSku = Sku.parseProduct(skuDetails);
        
        Assert.assertNotNull(testSku);
        Assert.assertEquals(expectedSku, testSku);
    }
    
    @Test
    public void testInvalidParseProduct() {
        String skuDetails = "H57 Tin O Beans 1.23";
        
        final Sku testSku = Sku.parseProduct(skuDetails);

        Assert.assertNull(testSku);
    }
    
    @Test
    public void testParseProductOffers() {
        String skuDetails = "H57\tTin O Beans\t1.23\t3 for 1.00";
        
        final Sku expectedSku = new Sku("H57", "Tin O Beans", "3 for 1.00", 
                new BigDecimal("1.23"), new MultipleOffer(3, new BigDecimal("1.00"))); 
        final Sku testSku = Sku.parseProduct(skuDetails);
                
        Assert.assertEquals(expectedSku, testSku);
    }
    
    @Test
    public void testHashCode() {
        final Sku test1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        final Sku test2 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        
        Assert.assertTrue(test1.hashCode() == test2.hashCode());
    }
    
    @Test
    public void testHashCodeForASymmetric() {
        final Sku test1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
    final Sku test2 = new Sku("C330", "Fruity Drink", "", new BigDecimal("0.54"), null); 
        
        Assert.assertTrue(test1.hashCode() != test2.hashCode());
    }
    
    @Test
    public void testEquals() {
        final Sku test1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        final Sku test2 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        
        Assert.assertTrue(test1.equals(test2));
    }
    
    @Test
    public void testEqualsASymmetric() {
        final Sku test1 = new Sku("H57", "Tin O Beans", "", new BigDecimal("1.23"), null); 
        final Sku test2 = new Sku("C330", "Fruity Drink", "", new BigDecimal("0.54"), null); 
        
        Assert.assertTrue(!test1.equals(test2));
    }
}
