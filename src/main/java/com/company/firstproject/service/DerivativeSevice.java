package com.company.firstproject.service;

import com.company.firstproject.entity.obligations.Obligation;

public interface DerivativeSevice {
    Obligation[] findByRiskRange(float startValue, float endValue);

    Obligation[] findByPayoutAmountRange(double startValue, double endValue);

    void sortByRisk();
}
