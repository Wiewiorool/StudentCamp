package pl.wiewior.studentcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    void transformName() {

    }

    @Test
    void getStudent() {
    }
}