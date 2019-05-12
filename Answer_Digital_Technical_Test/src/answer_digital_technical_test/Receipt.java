
package answer_digital_technical_test;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Objects;

public class Receipt {
    
    private ArrayList<Sku> list = new ArrayList<Sku>();
    private ArrayList<Saving> savings = new ArrayList<Saving>();
    private BigDecimal totalSavings;
    
    public Receipt(ArrayList<Sku> list){
        this.list = list;
        this.totalSavings = BigDecimal.ZERO;
    }
    
    public ArrayList<Sku> getList(){
        return this.list;
    }
    
    public BigDecimal getTotalSavings(){
        return this.totalSavings;
    }
    
    private void calculateSavings(){
        for (Sku sku : list) { 
            int itemCount = 1;
            Offer offer = sku.getOffer();
            
            if (offer != null){
                if (offer instanceof MultipleOffer){
                    itemCount = ((MultipleOffer) offer).getCount();
                    BigDecimal amountSaved = offer.totalSavings(itemCount, sku.getPrice());
                    savings.add(new Saving(sku.getDescription(), sku.getOfferType(), amountSaved));
                    totalSavings = totalSavings.add(amountSaved);
                }
                else if (offer instanceof BogofOffer){
                    itemCount = ((BogofOffer) offer).getCount();
                    BigDecimal amountSaved = offer.totalSavings(itemCount, sku.getPrice());
                    savings.add(new Saving(sku.getDescription(), sku.getOfferType(), amountSaved));
                    totalSavings = totalSavings.add(amountSaved);
                }
                else if (offer instanceof HalfPriceOffer){
                    BigDecimal amountSaved = offer.totalSavings(itemCount, sku.getPrice());
                    savings.add(new Saving(sku.getDescription(), sku.getOfferType(), amountSaved));
                    totalSavings = totalSavings.add(amountSaved);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        calculateSavings();
        
        String skuList = "";
        String savingList = "";

        for (Sku sku : list) {
            skuList += sku.toString();
        }
        
        for (Saving saving : savings) {
            savingList += saving.toString();
        }
        
       return "RECEIPT" + "\n" + "Product Code" + "\t" 
               + "Description" + "\t" + "Price" + "\n" + skuList + "\n" + 
               "SAVINGS" + "\n" + "Item" + "\t\t" + "Saving Type" + "\t" + "Total Saving" + "\n"
               + savingList + "\n\nOVERALL SAVINGS \n" + totalSavings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Receipt receipt = (Receipt) o;
        
        return Objects.equals(list, receipt.list) &&
                Objects.equals(savings, receipt.savings) &&
                Objects.equals(totalSavings, receipt.totalSavings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, savings, totalSavings);
    }
}
