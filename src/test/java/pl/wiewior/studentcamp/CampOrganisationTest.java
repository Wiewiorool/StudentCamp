package pl.wiewior.studentcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CampOrganisationTest {
    private CampOrganisation campOrganisation = new CampOrganisation(new ArrayList<>());

    @Test
    public void shouldNotAddStudentWhenFirstNameAndLastNameAreNull() {
        //given
        String newStudentFirstName = null;
        String newStudentLastName = null;

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(newStudentFirstName, newStudentLastName));
        //then
        Assertions.assertEquals("names cannot be null!", exception.getMessage());

    }

    @Test
    public void shouldNotAddStudentWhenFirstNameIsNull() {
        //given
        String newStudentFirstName = null;
        String newStudentLastName = "Gerard";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(newStudentFirstName, newStudentLastName));
        //then
        Assertions.assertEquals("names cannot be null!", exception.getMessage());

    }

    @Test
    public void shouldNotAddStudentWhenLastNameIsNull() {
        //given
        String newStudentFirstName = "Roman";
        String newStudentLastName = null;

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(newStudentFirstName, newStudentLastName));
        //then
        Assertions.assertEquals("names cannot be null!", exception.getMessage());

    }

    @Test
    public void shouldAddStudentWhenFirstNameAndLastNameAreNotNull() {
        //given
        String newStudentFirstName = "Andrew";
        String newStudentLastName = "Adams";

        //when
        boolean exception = campOrganisation.addStudent(newStudentFirstName, newStudentLastName);
        //then
        assertTrue(exception);

    }

    @Test
    public void shouldReturnFirstAndLastNameOfStudent() {
        //given
        String newStudentFirstName = "James";
        String newStudentLastName = "Bond";
        //when
        String transformName = campOrganisation.transformName(newStudentFirstName, newStudentLastName);
        //then
        Assertions.assertEquals("James Bond", transformName);

    }

    @Test
    public void shouldReturnNullAndLastNameOfStudent() {
        //given
        String newStudentFirstName = null;
        String newStudentLastName = "Bond";
        //when
        String transformName = campOrganisation.transformName(newStudentFirstName, newStudentLastName);
        //then
        Assertions.assertEquals("null Bond", transformName);

    }

    @Test
    public void shouldReturnFirstNameAndNullOfStudent() {
        //given
        String newStudentFirstName = "James";
        String newStudentLastName = null;
        //when
        String transformName = campOrganisation.transformName(newStudentFirstName, newStudentLastName);
        //then
        Assertions.assertEquals("James null", transformName);

    }

    @Test
    public void shouldReturnNullAndNullOfStudent() {
        //given
        String newStudentFirstName = null;
        String newStudentLastName = null;
        //when
        String transformName = campOrganisation.transformName(newStudentFirstName, newStudentLastName);
        //then
        Assertions.assertEquals("null null", transformName);

    }


    @Test
    void shouldReturnWhenStudentExist() {
        //given
        String firstName = "Josef";
        String lastName = "Adams";
        campOrganisation.addStudent(firstName,lastName);
        //when
        String actual = campOrganisation.getStudent(firstName);
        //then
        Assertions.assertEquals("Josef Adams", actual);

    }
    @Test
    void shouldReturnWhenStudentNotExist() {
        //given
        String firstName = "Josef";
        String lastName = "Adams";
        //when
        String actual = campOrganisation.getStudent(firstName);
        //then
        Assertions.assertEquals("", actual);

    }


}