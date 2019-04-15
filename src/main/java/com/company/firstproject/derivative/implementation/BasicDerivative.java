package com.company.firstproject.derivative.implementation;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.entity.obligations.Obligation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class BasicDerivative implements Derivative {

    private Obligation[] obligations;

    public BasicDerivative(Obligation[] obligations) {
        this.obligations = obligations;
    }

    @Override
    public List<Obligation> findByRiskRange(float startValue, float endValue) {
        return Arrays.stream(obligations)
                .filter(obligation -> obligation.isBetweenRisk(startValue, endValue))
                .collect(Collectors.toList());
    }

    @Override
    public List<Obligation> findByPayoutAmountRange(final double startValue, final double endValue) {
        return Arrays.stream(obligations)
                .filter(obligation -> obligation.isBetweenPayoutAmount(startValue, endValue))
                .collect(Collectors.toList());
    }

    @Override
    public void sortByRisk() {
        Arrays.sort(obligations);
    }

    @Override
    public List<Obligation> getObligations() {
        return Arrays.asList(obligations);
    }
}
