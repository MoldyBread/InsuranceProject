package com.company.firstproject.entity.obligations;

import com.company.firstproject.entity.InsuranceType;
import com.company.firstproject.exceptions.InvalidValuesException;
import com.company.firstproject.utils.Utils;

import java.io.Serializable;
import java.util.Objects;

public abstract class Obligation implements Comparable<Obligation>, Serializable {
    private int id;
    private InsuranceType insuranceType;
    private double payoutAmount;
    private double risk;

    public Obligation(int id, InsuranceType insuranceType, double payoutAmount, double risk)
            throws InvalidValuesException {
        Utils.validationUtil(id, payoutAmount);
        this.id = id;
        this.insuranceType = insuranceType;
        this.payoutAmount = payoutAmount;
        this.risk = risk;
    }


    public boolean isBetweenRisk(double startValue, double endValue) {
        return (risk <= endValue && risk >= startValue);
    }

    public boolean isBetweenPayoutAmount(double startValue, double endValue) {
        return (payoutAmount <= endValue && payoutAmount >= startValue);
    }

    @Override
    public String toString() {
        return "Obligation{" +
                "id=" + id +
                ", insuranceType=" + insuranceType +
                ", payoutAmount=" + payoutAmount +
                ", risk=" + risk +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Obligation that = (Obligation) o;
        return id == that.id &&
                Double.compare(that.payoutAmount, payoutAmount) == 0 &&
                Double.compare(that.risk, risk) == 0 &&
                insuranceType == that.insuranceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insuranceType, payoutAmount, risk);
    }

    @Override
    public int compareTo(Obligation o) {
        return Double.compare(risk, o.risk);
    }
}
