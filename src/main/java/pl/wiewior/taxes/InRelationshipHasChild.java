package pl.wiewior.taxes;

import java.math.BigDecimal;

public class InRelationshipHasChild implements TaxWay {
    private static final BigDecimal tax = BigDecimal.valueOf(0.2);

    @Override
    public BigDecimal calculateTax(BigDecimal yearlySalary) {
        return yearlySalary.multiply(tax);
    }
}
