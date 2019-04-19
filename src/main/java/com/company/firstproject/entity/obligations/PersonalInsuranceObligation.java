package com.company.firstproject.entity.obligations;

import com.company.firstproject.entity.InsuranceType;
import com.company.firstproject.exceptions.InvalidValuesException;

import java.util.Objects;

public class PersonalInsuranceObligation extends Obligation {

    private String categoryOfPersonalInsurance;

    public PersonalInsuranceObligation(int id, String categoryOfPersonalInsurance, double payoutAmount, float risk) throws InvalidValuesException {
        super(id, InsuranceType.PERSONAL, payoutAmount, risk);
        this.categoryOfPersonalInsurance = categoryOfPersonalInsurance;
    }

    @Override
    public String toString() {
        return "PersonalInsuranceObligation{" +
                "categoryOfPersonalInsurance='" + categoryOfPersonalInsurance + '\'' +
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
        PersonalInsuranceObligation that = (PersonalInsuranceObligation) o;
        return Objects.equals(categoryOfPersonalInsurance, that.categoryOfPersonalInsurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), categoryOfPersonalInsurance);
    }

}
