package pl.wiewior.taxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InRelationshipChildLessTest {
    private InRelationshipChildLess inRelationshipChildLess = new InRelationshipChildLess();

    @Test
    void calculateTax() {
        //given
        BigDecimal salary = BigDecimal.valueOf(10000);
        BigDecimal expected = salary.multiply(BigDecimal.valueOf(0.25));

        //when
        BigDecimal actual = inRelationshipChildLess.calculateTax(salary);
        //then
        Assertions.assertEquals(expected, actual);
    }
}