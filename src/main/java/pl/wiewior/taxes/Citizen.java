package pl.wiewior.taxes;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Citizen {
    private BigDecimal monthlySalary;
    private String firstName;
    private String lastName;
    private TaxWay taxWay;

    public BigDecimal calculateYearlyTax() {
        int year = 12;
        BigDecimal yearlySalary = monthlySalary.multiply(BigDecimal.valueOf(year));
        BigDecimal yearlyTax = taxWay.calculateTax(yearlySalary);
        return yearlyTax;
    }


}
