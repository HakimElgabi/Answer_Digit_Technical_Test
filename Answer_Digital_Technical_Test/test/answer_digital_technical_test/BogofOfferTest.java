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
public class BogofOfferTest {
    
    @Test
    public void testTotalSavings() {
        BogofOffer testBogofOffer = new BogofOffer();

        BigDecimal expectedSavings = new BigDecimal("2.16");
        BigDecimal testSavings = testBogofOffer.totalSavings(2, new BigDecimal("2.16"));

        Assert.assertNotNull(testSavings);
        Assert.assertEquals(expectedSavings, testSavings);
    }
}
