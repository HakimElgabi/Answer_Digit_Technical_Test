
package answer_digital_technical_test;

import java.math.BigDecimal;
import java.util.Objects;

public class MultipleOffer implements Offer {
    
    private final int count;
    private final BigDecimal totalPrice;

    public MultipleOffer(int count, BigDecimal totalPrice) {
        this.count = count;
        this.totalPrice = totalPrice;
    }
    
    public int getCount() {
        return this.count;
    }

    @Override
    public BigDecimal totalSavings(int count, BigDecimal itemPrice) {
        return calculateTotalSavings(count, itemPrice, false);
    }

    BigDecimal calculateTotalSavings(int quantity, BigDecimal itemPrice, boolean isBogofOffer) {
        if (quantity <= 1 || itemPrice == null || itemPrice.signum() == -1 || itemPrice.signum() == 0) 
            return null;
        
        int availableOffers = quantity / count;

        if (isBogofOffer) 
            quantity /= 2;

        BigDecimal totalSavings = itemPrice.multiply(new BigDecimal(quantity));

        BigDecimal totalCostFromOffers = totalPrice.multiply(new BigDecimal(availableOffers));
        
        return totalSavings.subtract(totalCostFromOffers);
    }

    @Override
    public boolean equals(Object o) {
         if (o == this) return true;
        
        if (!(o instanceof MultipleOffer)) {
            return false;
        }
        MultipleOffer that = (MultipleOffer) o;
        
        return Objects.equals(count, that.count) &&
                Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, totalPrice);
    }
}
