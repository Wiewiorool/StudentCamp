package pl.wiewior.taxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InRelationshipChildLessTest {
    private InRelationshipChildLess inRelationshipChildLess = new InRelationshipChildLess();
    private static final BigDecimal tax = BigDecimal.valueOf(0.25);

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new BigDecimal(10000), tax),
                Arguments.of(new BigDecimal(0), tax),
                Arguments.of(new BigDecimal(-10000), tax)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void calculateTax(BigDecimal salary, BigDecimal tax) {
        //given
        //when
        BigDecimal actual = inRelationshipChildLess.calculateTax(salary);
        //then
        Assertions.assertEquals(salary.multiply(tax).setScale(2), actual);
    }
}