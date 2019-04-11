package com.company.firstproject;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.derivative.implementation.BasicDerivative;
import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.entity.obligations.PersonalInsuranceObligation;
import com.company.firstproject.entity.obligations.PropertyInsuranceObligation;
import com.company.firstproject.service.DerivativeSevice;
import com.company.firstproject.service.implementation.BasicDerivativeService;
import com.company.firstproject.ui.ConsoleUI;

public class ConsoleApplication {
    public static void main(String[] args) {
        Obligation[] obligations = new Obligation[12];
        obligations[0] = new PropertyInsuranceObligation(12, "Basic responsibility", 120000, 0.15F);
        obligations[1] = new PropertyInsuranceObligation(32, "Basic property", 90500, 0.01F);
        obligations[2] = new PropertyInsuranceObligation(43, "Business risks", 1000000, 0.69F);
        obligations[3] = new PropertyInsuranceObligation(54, "Financial risks", 190230, 0.28F);
        obligations[4] = new PropertyInsuranceObligation(77, "Basic vehicle insurance", 104000, 0.44F);
        obligations[5] = new PropertyInsuranceObligation(91, "Professional responsibility", 532100, 0.57F);

        obligations[6] = new PersonalInsuranceObligation(73, "Life", 102000, 0.1F);
        obligations[7] = new PersonalInsuranceObligation(82, "Accidents", 95300, 0.2F);
        obligations[8] = new PersonalInsuranceObligation(99, "Medical", 221000, 0.17F);
        obligations[9] = new PersonalInsuranceObligation(110, "Accidents", 111000, 0.31F);
        obligations[10] = new PersonalInsuranceObligation(101, "Life", 132000, 0.23F);
        obligations[11] = new PersonalInsuranceObligation(212, "Medical", 340100, 0.19F);

        Derivative derivative = new BasicDerivative(obligations);

        DerivativeSevice derivativeSevice = new BasicDerivativeService(derivative);

        ConsoleUI consoleUI = new ConsoleUI(derivativeSevice);
        consoleUI.run();
    }
}
