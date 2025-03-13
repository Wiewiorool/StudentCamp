package pl.wiewior.taxes;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Report {
    private String citizenFirstName;
    private String citizenLastName;
    private BigDecimal yearlySalary;
    private BigDecimal tax;
}
