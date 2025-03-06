package pl.wiewior.taxes;

import java.math.BigDecimal;

public interface TaxWay {
    public BigDecimal calculateTax(BigDecimal yearlySalary);

}
