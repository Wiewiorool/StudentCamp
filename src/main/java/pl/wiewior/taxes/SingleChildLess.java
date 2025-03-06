package pl.wiewior.taxes;

import java.math.BigDecimal;

public class SingleChildLess implements TaxWay {
    private BigDecimal tax = BigDecimal.valueOf(0.39);

    @Override
    public BigDecimal calculateTax(BigDecimal yearlySalary) {
        return yearlySalary.multiply(tax);
    }
}
