package com.company.firstproject.service.implementation;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.service.DerivativeSevice;

public class BasicDerivativeService implements DerivativeSevice {

    private Derivative derivative;

    public BasicDerivativeService(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public Obligation[] findByRiskRange(float startValue, float endValue) {
        return derivative.findByRiskRange(startValue, endValue);
    }

    @Override
    public Obligation[] findByPayoutAmountRange(double startValue, double endValue) {
        return derivative.findByPayoutAmountRange(startValue, endValue);
    }

    @Override
    public void sortByRisk() {
        derivative.sortByRisk();
    }

    @Override
    public Obligation[] getObligations() {
        return derivative.getObligations();
    }

    @Override
    public String toString() {
        return derivative.toString();
    }


}
