package com.company.firstproject.entity.obligations;

import com.company.firstproject.entity.InsuranceType;
import com.company.firstproject.exceptions.InvalidValuesException;

import java.util.Objects;

public class PropertyInsuranceObligation extends Obligation {

    private String nameOfPropertyInsurance;

    public PropertyInsuranceObligation(int id, String nameOfPropertyInsurance, double payoutAmount, double risk)
            throws InvalidValuesException {
        super(id, InsuranceType.PROPERTY, payoutAmount, risk);
        this.nameOfPropertyInsurance = nameOfPropertyInsurance;
    }

    @Override
    public String toString() {
        return "PropertyInsuranceObligation{" +
                "nameOfPropertyInsurance='" + nameOfPropertyInsurance + '\'' +
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
        if (!super.equals(o)) {
            return false;
        }
        PropertyInsuranceObligation that = (PropertyInsuranceObligation) o;
        return Objects.equals(nameOfPropertyInsurance, that.nameOfPropertyInsurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameOfPropertyInsurance);
    }
}
