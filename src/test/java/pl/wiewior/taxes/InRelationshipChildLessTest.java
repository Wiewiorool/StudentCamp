package pl.wiewior.taxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

class InRelationshipChildLessTest {
    private TaxWay inRelationshipChildLess = new InRelationshipChildLess();
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(0.25);

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new BigDecimal(10000)),
                Arguments.of(new BigDecimal(0)),
                Arguments.of(new BigDecimal(-10000))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void calculateTax(BigDecimal salary) {
        //given
        //when
        BigDecimal actual = inRelationshipChildLess.calculateTax(salary);
        //then
        Assertions.assertEquals(salary.multiply(TAX_VALUE).setScale(2), actual);
    }
}