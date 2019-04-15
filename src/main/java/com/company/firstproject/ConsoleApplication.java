package com.company.firstproject;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.derivative.implementation.BasicDerivative;
import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.service.DerivativeService;
import com.company.firstproject.service.implementation.BasicDerivativeService;
import com.company.firstproject.ui.ConsoleUI;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ConsoleApplication {
    public static void main(String[] args) {
        Obligation[] obligations;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obligations.dat"))) {
            obligations = (Obligation[]) ois.readObject();

            Derivative derivative = new BasicDerivative(obligations);

            DerivativeService derivativeService = new BasicDerivativeService(derivative);

            ConsoleUI consoleUI = new ConsoleUI(derivativeService);
            consoleUI.run();
        } catch (Exception ex) {

            System.out.println(ex.getLocalizedMessage());
        }

    }
}
