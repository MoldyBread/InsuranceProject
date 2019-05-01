package com.company.firstproject;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.derivative.implementation.BasicDerivative;
import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.exceptions.InvalidValuesException;
import com.company.firstproject.service.DerivativeService;
import com.company.firstproject.service.implementation.BasicDerivativeService;
import com.company.firstproject.ui.ConsoleUI;
import com.company.firstproject.utils.Utils;

public class ConsoleApplication {
    public static void main(String[] args) throws InvalidValuesException {
        Obligation[] obligations = Utils.serializationUtil();
        Derivative derivative = new BasicDerivative(obligations);
        DerivativeService derivativeService = new BasicDerivativeService(derivative);
        ConsoleUI consoleUI = new ConsoleUI(derivativeService);
        consoleUI.run();
    }
}
