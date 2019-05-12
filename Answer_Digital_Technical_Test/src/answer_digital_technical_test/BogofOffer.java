
package answer_digital_technical_test;

import java.math.BigDecimal;

public class BogofOffer extends MultipleOffer {
    
    public BogofOffer() {
        super(2, BigDecimal.ZERO);
    }

    @Override
    public BigDecimal totalSavings(int count, BigDecimal itemPrice) {
        return calculateTotalSavings(count, itemPrice, true);
    }
}
