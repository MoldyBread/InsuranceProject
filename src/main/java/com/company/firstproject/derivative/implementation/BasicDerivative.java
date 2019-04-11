package com.company.firstproject.derivative.implementation;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.entity.obligations.Obligation;

import java.util.Arrays;


public class BasicDerivative implements Derivative {

    private Obligation[] obligations;

    public BasicDerivative(Obligation[] obligations) {
        this.obligations = obligations;
    }

    @Override
    public Obligation[] findByRiskRange(float startValue, float endValue) {
        Obligation[] result = new Obligation[obligations.length];
        int i = 0;

        for (Obligation obligation : obligations) {
            if (obligation.getRisk() <= endValue && obligation.getRisk() >= startValue) {
                result[i] = obligation;
                i++;
            }
        }
        return normalizedArray(result, i);
    }

    @Override
    public Obligation[] findByPayoutAmountRange(double startValue, double endValue) {
        Obligation[] result = new Obligation[obligations.length];
        int i = 0;

        for (Obligation obligation : obligations) {
            if (obligation.getPayoutAmount() <= endValue && obligation.getPayoutAmount() >= startValue) {
                result[i] = obligation;
                i++;
            }
        }
        return normalizedArray(result, i);
    }

    private Obligation[] normalizedArray(Obligation[] input, int lastIndex) {
        if (lastIndex == obligations.length - 1) {
            return input;
        }
        Obligation[] result = new Obligation[lastIndex];
        System.arraycopy(input, 0, result, 0, lastIndex);
        return result;
    }

    @Override
    public void sortByRisk() {
        Arrays.sort(obligations);
    }

    @Override
    public Obligation[] getObligations() {
        return obligations;
    }
}
