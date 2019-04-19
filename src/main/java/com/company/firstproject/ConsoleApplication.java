package com.company.firstproject;

import com.company.firstproject.derivative.Derivative;
import com.company.firstproject.derivative.implementation.BasicDerivative;
import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.service.DerivativeService;
import com.company.firstproject.service.implementation.BasicDerivativeService;
import com.company.firstproject.ui.ConsoleUI;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsoleApplication {
    public static void main(String[] args) {

        //For mvn install set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_192"
        
        Obligation[] obligations;
        final Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obligations.dat"))) {
            obligations = (Obligation[]) ois.readObject();

            Derivative derivative = new BasicDerivative(obligations);

            DerivativeService derivativeService = new BasicDerivativeService(derivative);

            ConsoleUI consoleUI = new ConsoleUI(derivativeService);
            consoleUI.run();
        } catch (Exception ex) {
            logger.log(Level.WARNING,ex.getMessage());
        }

    }
}
