package com.company.firstproject.derivative;

import com.company.firstproject.entity.obligations.Obligation;

public interface Derivative {
    Obligation[] findByRiskRange(float startValue, float endValue);

    Obligation[] findByPayoutAmountRange(double startValue, double endValue);

    void sortByRisk();

    Obligation[] getObligations();
}
