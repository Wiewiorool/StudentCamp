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
        BigDecimal yearlySalary = yearlySalary();
        BigDecimal yearlyTax = taxWay.calculateTax(yearlySalary);
        return yearlyTax;
    }

    public BigDecimal yearlySalary(){
        return monthlySalary.multiply(BigDecimal.valueOf(12));
    }

    @Override
    public String toString() {
        return "Report:\n" +
                "Name: " + firstName + "\n" +
                "Surname: " + lastName + "\n" +
                "Salary: " + monthlySalary + " \n" +
                //Salary need to be yearly. Still try to figure it out.
                "Yearly tax: " + calculateYearlyTax() + " \n";
    }

}
