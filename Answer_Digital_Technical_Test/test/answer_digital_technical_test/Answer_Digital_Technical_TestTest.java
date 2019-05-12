/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import java.io.FileNotFoundException;
import java.io.IOException;
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
public class Answer_Digital_Technical_TestTest {
    
    public String expectedString =
            "Product Code	Description	Price	Offer\n" +
            "H57		Tin O Beans	1.23	Half Price\n" +
            "C330		Fruity Drink	0.54	3 for 1.00\n" +
            "BR7		Sliced Loaf	1.54	\n" +
            "X546		2 Litre Milk	2.16	BOGOF\n";
    
    @Test
    public void testParsingInputFile() throws FileNotFoundException, IOException {
        final Store store = new Store();

        Answer_Digital_Technical_Test test = new Answer_Digital_Technical_Test();
        
        String testString = test.parsingInputFile(store);
        
        Assert.assertEquals(testString, expectedString);
    }
    
}
