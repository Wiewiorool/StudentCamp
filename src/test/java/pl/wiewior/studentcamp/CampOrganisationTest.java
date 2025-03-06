package pl.wiewior.studentcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CampOrganisationTest {
    private CampOrganisation campOrganisation = new CampOrganisation(new ArrayList<>());

    public static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, "Gerard"),
                Arguments.of("Roman", null)
        );
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(null, "Bond", "null Bond"),
                Arguments.of("James", null, "James null"),
                Arguments.of(null, null, "null null"),
                Arguments.of("James", "Bond", "James Bond")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void shouldNotAddStudentWhenFirstNameAndLastNameAreNull(String firstName, String lastName) {
        //given
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(firstName, lastName));
        //then
        Assertions.assertEquals("names cannot be null!", exception.getMessage());
    }

    @Test
    public void shouldAddStudent() {
        //given
        String newStudentFirstName = "Andrew";
        String newStudentLastName = "Adams";

        //when
        boolean actual = campOrganisation.addStudent(newStudentFirstName, newStudentLastName);
        //then
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldReturnNullAndLastNameOfStudent(String firstName, String lastName, String expected) {
        //given
        //when
        String transformName = campOrganisation.transformName(firstName, lastName);
        //then
        Assertions.assertEquals(expected, transformName);
    }

    @Test
    void shouldReturnWhenStudentExist() {
        //given
        String firstName = "Josef";
        String lastName = "Adams";
        campOrganisation.addStudent(firstName, lastName);
        //when
        String actual = campOrganisation.getStudent(firstName);
        //then
        Assertions.assertEquals("Josef Adams", actual);
    }

    @Test
    void shouldReturnWhenStudentNotExist() {
        //given
        String firstName = "Josef";
        //when
        String actual = campOrganisation.getStudent(firstName);
        //then
        Assertions.assertEquals("", actual);
    }
}