
package answer_digital_technical_test;

import java.math.BigDecimal;
import java.util.Objects;

public class Saving {
    final private String description;
    final private String savingType;
    final private BigDecimal totalSaving;
    
    public Saving(String description, String savingType, BigDecimal totalSaving){
        this.description = description;
        this.savingType = savingType;
        this.totalSaving = totalSaving;
    }
    
    public String getDescription() {
        return description;
    }

    public String getSavingType() {
        return savingType;
    }

    public BigDecimal getTotalSaving() {
        return totalSaving;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        
        if (!(o instanceof Saving)) {
            return false;
        }
        
        Saving saving = (Saving) o;
        
        return Objects.equals(description, saving.description) &&
                Objects.equals(savingType, saving.savingType) &&
                Objects.equals(totalSaving, saving.totalSaving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, savingType, totalSaving);
    }

    @Override
    public String toString() {
        return description + "\t" + savingType + "\t" + totalSaving + "\n";

    }
}
