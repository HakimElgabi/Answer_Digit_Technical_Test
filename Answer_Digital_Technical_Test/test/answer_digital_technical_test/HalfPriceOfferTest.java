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
public class HalfPriceOfferTest {
    
    @Test
    public void testTotalSavings() {
        HalfPriceOffer testHalfPriceOffer = new HalfPriceOffer();

        BigDecimal expectedSavings = new BigDecimal("1.08");
        BigDecimal testSavings = testHalfPriceOffer.totalSavings(1, new BigDecimal("2.16"));

        Assert.assertNotNull(testSavings);
        Assert.assertEquals(expectedSavings, testSavings);
    }
    
    @Test
    public void testInvalidQuantity() {
        HalfPriceOffer testHalfPriceOffer = new HalfPriceOffer();

        BigDecimal testSavings = testHalfPriceOffer.totalSavings(0, new BigDecimal("2.16"));

        Assert.assertNull(testSavings);
    }
    
    @Test
    public void testNegativeItemPrice() {
        HalfPriceOffer testHalfPriceOffer = new HalfPriceOffer();

        BigDecimal testSavings = testHalfPriceOffer.totalSavings(0, new BigDecimal("-2.16"));

        Assert.assertNull(testSavings);
    }
    
    @Test
    public void testInvalidItemPrice() {
        HalfPriceOffer testHalfPriceOffer = new HalfPriceOffer();

        BigDecimal testSavings = testHalfPriceOffer.totalSavings(0, new BigDecimal("0.00"));

        Assert.assertNull(testSavings);
    }
}
