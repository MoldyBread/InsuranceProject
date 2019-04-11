package com.company.firstproject.entity.obligations;

import com.company.firstproject.entity.InsuranceType;

import java.util.Objects;

public abstract class Obligation implements Comparable<Obligation> {
    private int id;
    private InsuranceType insuranceType;
    private double payoutAmount;
    private Float risk;

    public Obligation(int id, InsuranceType insuranceType, double payoutAmount, float risk) {
        this.id = id;
        this.insuranceType = insuranceType;
        this.payoutAmount = payoutAmount;
        this.risk = risk;
    }

    public int getId() {
        return id;
    }

    public double getPayoutAmount() {
        return payoutAmount;
    }

    public Float getRisk() {
        return risk;
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
                Float.compare(that.risk, risk) == 0 &&
                insuranceType == that.insuranceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insuranceType, payoutAmount, risk);
    }

    @Override
    public int compareTo(Obligation o) {
        return risk.compareTo(o.risk);
    }
}


