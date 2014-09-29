

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PersonAndOrganisationNumberValidatorTest {

    private final static String VALID_PERSON_ID_NUMBER = "197903081128";
    private final static String VALID_ORGANISATION_ID_NUMBER = "195565869996";
    private final static String INVALID_PERSON_ID_NUMBER_WITH_WRONG_CONTROL_NUMBER = "197903081127";
    private final static String INVALID_ORGANISATION_NUMBER_WITH_WRONG_CONTROL_NUMBER = "195565869995";

    PersonAndOrganisationNumberValidator personAndOrganisationNumberValidator = new PersonAndOrganisationNumberValidator();

    @Test
    public void personIdentityNumberIsCorrectTest() throws Exception {
        assertTrue(personAndOrganisationNumberValidator.isPersonlIdentityNumberValid(VALID_PERSON_ID_NUMBER));
    }

    @Test
    public void organationNumberIsCorrectTest() throws Exception {
        assertTrue(personAndOrganisationNumberValidator.isOrganisationNumberValid(VALID_ORGANISATION_ID_NUMBER));
    }

    @Test
    public void personIdentityNumberHoldsWrongControlNumber() throws Exception {
        assertFalse(personAndOrganisationNumberValidator.isPersonlIdentityNumberValid(INVALID_PERSON_ID_NUMBER_WITH_WRONG_CONTROL_NUMBER));
    }

    @Test
    public void organisationyNumberHoldsWrongControlNumber() throws Exception {
        assertFalse(personAndOrganisationNumberValidator.isOrganisationNumberValid(INVALID_ORGANISATION_NUMBER_WITH_WRONG_CONTROL_NUMBER));
    }
}