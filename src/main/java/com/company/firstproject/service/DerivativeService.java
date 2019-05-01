package com.company.firstproject.service;

import com.company.firstproject.entity.obligations.Obligation;

import java.util.List;

public interface DerivativeService {
    List<Obligation> findByRiskRange(double startValue, double endValue);

    List<Obligation> findByPayoutAmountRange(double startValue, double endValue);

    Obligation[] sortByRisk();

    List<Obligation> getObligations();
}
