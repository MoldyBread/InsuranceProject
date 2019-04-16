package com.company.firstproject.service.implementation;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.entity.obligations.PersonalInsuranceObligation;
import com.company.firstproject.entity.obligations.PropertyInsuranceObligation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicDerivativeServiceTest {

    @Mock
    private Derivative derivative;
    @InjectMocks
    private BasicDerivativeService basicDerivativeService;


    @Test
    public void shouldBeSorted() {
        Obligation[] obligations = new Obligation[]{
                new PropertyInsuranceObligation(1,"1",1,0.1f),
                new PersonalInsuranceObligation(2,"2",2,0.2f)
        };
        when(derivative.sortByRisk()).thenReturn(obligations);

        Obligation[] actual = basicDerivativeService.sortByRisk();
        Obligation[] expected = {
                new PropertyInsuranceObligation(1,"1",1,0.1f),
                new PersonalInsuranceObligation(2,"2",2,0.2f)
        };

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnRangeByRisk() {
        Obligation[] obligations = {new PropertyInsuranceObligation(1, "1", 2, 0.5F)};
        when(derivative.findByRiskRange(0f, 1f)).thenReturn(Arrays.asList(obligations));
        Obligation actual = basicDerivativeService.findByRiskRange(0, 1).get(0);
        Obligation expected = new PropertyInsuranceObligation(1, "1", 2, 0.5F);

        assertEquals(expected, actual);
    }


    @Test
    public void shouldReturnRangeByPayoutAmount() {
        Obligation[] obligations = {new PersonalInsuranceObligation(11, "21", 9, 0.5F)};
        when(derivative.findByPayoutAmountRange(0, 10)).thenReturn(Arrays.asList(obligations));
        Obligation actual = basicDerivativeService.findByPayoutAmountRange(0, 10).get(0);
        Obligation expected = new PersonalInsuranceObligation(11, "21", 9, 0.5F);

        assertEquals(expected, actual);
    }
}
