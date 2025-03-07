package pl.wiewior.taxes;

import java.math.BigDecimal;

public class InRelationshipHasChild implements TaxWay {
    private BigDecimal tax = BigDecimal.valueOf(0.2);

    @Override
    public BigDecimal calculateTax(BigDecimal yearlySalary) {
        return yearlySalary.multiply(tax);
    }
}
