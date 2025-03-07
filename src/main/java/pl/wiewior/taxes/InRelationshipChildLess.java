package pl.wiewior.taxes;

import java.math.BigDecimal;

public class InRelationshipChildLess implements TaxWay {
    private BigDecimal tax = BigDecimal.valueOf(0.25);

    @Override
    public BigDecimal calculateTax(BigDecimal yearlySalary) {
        return yearlySalary.multiply(tax);
    }
}
