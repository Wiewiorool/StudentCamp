package pl.wiewior.taxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InRelationshipChildLessTest {
    private InRelationshipChildLess inRelationshipChildLess = new InRelationshipChildLess();

    @Test
    void calculateTaxWhen() {
        //given
        BigDecimal salary = BigDecimal.valueOf(2500);
        BigDecimal expected = BigDecimal.valueOf(625.00).setScale(2);

        //when
        BigDecimal actual = inRelationshipChildLess.calculateTax(salary);
        //then
        Assertions.assertEquals(expected, actual);
    }
}