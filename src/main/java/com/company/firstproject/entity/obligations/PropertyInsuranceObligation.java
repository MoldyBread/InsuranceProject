package com.company.firstproject.entity.obligations;

import com.company.firstproject.entity.InsuranceType;

import java.util.Objects;

public class PropertyInsuranceObligation extends Obligation {

    private String categoryOfPropertyInsurance;

    public PropertyInsuranceObligation(int id, String categoryOfPropertyInsurance, double payoutAmount, float risk) {
        super(id, InsuranceType.PROPERTY, payoutAmount, risk);
        this.categoryOfPropertyInsurance=categoryOfPropertyInsurance;
    }

    public String getCategoryOfPropertyInsurance() {
        return categoryOfPropertyInsurance;
    }

    @Override
    public String toString() {
        return "PropertyInsuranceObligation{" +
                "categoryOfPropertyInsurance='" + categoryOfPropertyInsurance + '\'' +
                super.toString() +
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
        if (!super.equals(o)){
            return false;
        }
        PropertyInsuranceObligation that = (PropertyInsuranceObligation) o;
        return Objects.equals(categoryOfPropertyInsurance, that.categoryOfPropertyInsurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), categoryOfPropertyInsurance);
    }
}
