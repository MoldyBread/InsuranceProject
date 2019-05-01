package com.company.firstproject.entity.obligations;

import com.company.firstproject.exceptions.InvalidValuesException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ObligationTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void shouldThrowInvalidValuesException() throws InvalidValuesException {
        thrown.expect(InvalidValuesException.class);
        Obligation obligations = new PersonalInsuranceObligation(-1, "21", 0, 0.5F);

    }
}
