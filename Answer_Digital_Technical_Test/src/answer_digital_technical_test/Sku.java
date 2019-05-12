/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer_digital_technical_test;

import java.math.BigDecimal;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sku {
    
    private String productCode;
    private String description;
    private String offerType;
    private BigDecimal price;
    private Offer offer;
    
    public Sku(){
        
    }
    
    public Sku(String productCode, String description, String offerType, BigDecimal price, Offer offer){
        this.productCode = productCode;
        this.description = description;
        this.offerType = offerType;
        this.price = price;
        this.offer = offer;
    }
    
    public String getProductCode()
    {
        return this.productCode;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public String getOfferType()
    {
        return this.offerType;
    }
    
    public BigDecimal getPrice()
    {
        return this.price;
    }
    
    public Offer getOffer()
    {
        return this.offer;
    }
    
    public static Offer setOffer (String offer)
    {
        final String BOGOF_OFFER = "bogof";
        final String HALF_PRICE = "half price";
        final String MULTIPLE_OFFER = "(\\d*) for (\\d*.*\\d+)";
        
        final Pattern MULTIPLE_OFFER_PATTERN = Pattern.compile(MULTIPLE_OFFER);
        
        if (offer.toLowerCase().matches(BOGOF_OFFER))
            return new BogofOffer();
        else if (offer.toLowerCase().matches(HALF_PRICE))
            return new HalfPriceOffer();
        else if (offer.toLowerCase().matches(MULTIPLE_OFFER)){
            final Matcher matcher = MULTIPLE_OFFER_PATTERN.matcher(offer);
            if (matcher.find()) {
                return new MultipleOffer(Integer.parseInt(matcher.group(1)), new BigDecimal(matcher.group(2)));
            }
        }
        return null;
    }
    
    public static Sku parseProduct(String skuList) {
        if (skuList == null || skuList.isEmpty()) 
            return null;

        // split the provided string on tabs
        String[] skuData = skuList.split("\t");

        // at least the first 3 elements are required. A fourth element 'Offer' is optional
        if (skuData.length < 3) return null;

        // validate each field
        for (String line : skuData) {
            if (line == null || line.isEmpty()) {
                return null;
            }
        }

        try {
            // parse price field
            final BigDecimal price = new BigDecimal(skuData[2]);
            String offerType = "";

            // parse optional offer field
            Offer offer = null;
            if (skuData.length > 3) {
                offer = setOffer(skuData[3]);
                offerType = skuData[3];
            }

            return new Sku(skuData[0], skuData[1], offerType, price, offer);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String toString() {
        return productCode + "\t\t" + description + "\t" + price + "\t" + offerType +  "\n";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        
        if (!(o instanceof Sku)) {
            return false;
        }

        Sku sku = (Sku) o;

        return Objects.equals(productCode, sku.productCode) && 
                Objects.equals(description, sku.description) &&
                Objects.equals(offerType, sku.offerType) && 
                Objects.equals(price, sku.price) &&
                Objects.equals(offer, sku.offer);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(productCode, description, price, offer);
    }
}
