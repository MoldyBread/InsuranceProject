package com.company.firstproject.service.implementation;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.service.DerivativeService;

import java.util.List;

public class BasicDerivativeService implements DerivativeService {

    private Derivative derivative;

    public BasicDerivativeService(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public List<Obligation> findByRiskRange(float startValue, float endValue) {
        return derivative.findByRiskRange(startValue, endValue);
    }

    @Override
    public List<Obligation> findByPayoutAmountRange(double startValue, double endValue) {
        return derivative.findByPayoutAmountRange(startValue, endValue);
    }

    @Override
    public Obligation[] sortByRisk() {
        return derivative.sortByRisk();
    }

    @Override
    public List<Obligation> getObligations() {
        return derivative.getObligations();
    }

    @Override
    public String toString() {
        return derivative.toString();
    }


}
