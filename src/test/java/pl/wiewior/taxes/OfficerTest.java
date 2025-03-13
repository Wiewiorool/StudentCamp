package pl.wiewior.taxes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class OfficerTest {
  private Officer officer = new Officer();

  @Mock
  private Citizen citizen;

  @BeforeEach
  public void setUp(){
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void shouldGenerateReport(){
    //given
    String citizenFirstName = "anyFirstName";
    when(citizen.getFirstName()).thenReturn(citizenFirstName);

    String citizenLastName = "anyLastName";
    when(citizen.getLastName()).thenReturn(citizenLastName);

    BigDecimal expectedYearlySalary = BigDecimal.valueOf(120_000);
    when(citizen.yearlySalary()).thenReturn(expectedYearlySalary);

    BigDecimal expectedTax = BigDecimal.valueOf(40_000);
    when(citizen.calculateYearlyTax()).thenReturn(expectedTax);

    //when
    Report report = officer.getReport(citizen);

    //then
    Assertions.assertEquals(citizenFirstName, report.getCitizenFirstName());
    Assertions.assertEquals(citizenLastName, report.getCitizenLastName());
    Assertions.assertEquals(expectedYearlySalary, report.getYearlySalary());
    Assertions.assertEquals(expectedTax, report.getTax());
  }

}