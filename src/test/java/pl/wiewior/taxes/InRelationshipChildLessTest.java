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

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new BigDecimal(10000), new BigDecimal(0.25)),
                Arguments.of(new BigDecimal(0), new BigDecimal(0.25)),
                Arguments.of(new BigDecimal(-10000), new BigDecimal(0.25))
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