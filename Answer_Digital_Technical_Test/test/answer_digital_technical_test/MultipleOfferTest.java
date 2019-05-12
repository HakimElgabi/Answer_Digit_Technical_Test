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
public class MultipleOfferTest {
        
    @Test
    public void testTotalSavings() {
        MultipleOffer testMultipleOffer = new MultipleOffer(3, BigDecimal.ONE);

        BigDecimal expectedSavings = new BigDecimal("0.62");
        BigDecimal testSavings = testMultipleOffer.totalSavings(3, new BigDecimal("0.54"));

        Assert.assertNotNull(testSavings);
        Assert.assertEquals(expectedSavings, testSavings);
    }
    
    @Test
    public void testQuantityTooLow() {
        MultipleOffer testMultipleOffer = new MultipleOffer(3, BigDecimal.ONE);

        BigDecimal testSavings = testMultipleOffer.totalSavings(1, new BigDecimal("0.54"));

        Assert.assertNull(testSavings);
    }
    
    @Test
    public void testItemPriceNull() {
        MultipleOffer testMultipleOffer = new MultipleOffer(3, BigDecimal.ONE);

        BigDecimal testSavings = testMultipleOffer.totalSavings(3, null);

        Assert.assertNull(testSavings);
    }
    
        
    @Test
    public void testItemPriceNegative() {
        MultipleOffer testMultipleOffer = new MultipleOffer(3, BigDecimal.ONE);

        BigDecimal testSavings = testMultipleOffer.totalSavings(3, new BigDecimal("-0.54"));

        Assert.assertNull(testSavings);
    }
}
