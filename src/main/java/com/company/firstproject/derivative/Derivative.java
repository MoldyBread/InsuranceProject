package com.company.firstproject.derivative;

import com.company.firstproject.entity.obligations.Obligation;

import java.util.List;

public interface Derivative {
    List<Obligation> findByRiskRange(double startValue, double endValue);

    List<Obligation> findByPayoutAmountRange(double startValue, double endValue);

    Obligation[] sortByRisk();

    List<Obligation> getObligations();
}
