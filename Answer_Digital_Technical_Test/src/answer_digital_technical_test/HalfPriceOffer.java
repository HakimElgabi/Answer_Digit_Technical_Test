
package answer_digital_technical_test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class HalfPriceOffer implements Offer {
    
    @Override
    public BigDecimal totalSavings(int quantity, BigDecimal itemPrice) {
        if (quantity <= 0 || itemPrice == null || itemPrice.signum() == -1 || itemPrice.signum() == 0) 
            return null;

        final BigDecimal halfPrice = itemPrice.divide(BigDecimal.valueOf(2), RoundingMode.HALF_EVEN);
        
        return halfPrice.multiply(new BigDecimal(quantity));
    }
}
