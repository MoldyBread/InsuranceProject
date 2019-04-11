package com.company.firstproject.entity.obligations;

import com.company.firstproject.entity.InsuranceType;

import java.util.Objects;

public class PersonalInsuranceObligation extends Obligation {

    private String nameOfInsurance;

    public PersonalInsuranceObligation(int id, String nameOfInsurance, double payoutAmount, float risk) {
        super(id, InsuranceType.PERSONAL, payoutAmount, risk);
        this.nameOfInsurance = nameOfInsurance;
    }

    public String getNameOfInsurance() {
        return nameOfInsurance;
    }

    @Override
    public String toString() {
        return "PersonalInsuranceObligation{" +
                "nameOfInsurance='" + nameOfInsurance + '\'' +
                super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonalInsuranceObligation that = (PersonalInsuranceObligation) o;
        return Objects.equals(nameOfInsurance, that.nameOfInsurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameOfInsurance);
    }
}
