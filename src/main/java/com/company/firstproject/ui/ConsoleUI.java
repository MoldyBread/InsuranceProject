package com.company.firstproject.ui;

import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.service.DerivativeSevice;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleUI {

    private DerivativeSevice derivativeSevice;
    private Scanner scanner;


    public ConsoleUI(DerivativeSevice derivativeSevice) {
        this.derivativeSevice = derivativeSevice;
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
    }

    public void run() {
        int state;
        System.out.println("Hello, this is my console app project.\n");

        while (true) {
            state = menuRunner();
            if (state == 4) {
                break;
            }
            if (state > 4 || state < 0) {
                System.out.println("Wrong input\n");
            }
        }
    }

    private int menuRunner() {
        System.out.println("Menu:\n" +
                "1. Show all obligations\n" +
                "2. Sort obligations\n" +
                "3. Find by parameters\n" +
                "4. Exit");
        System.out.println("\nEnter what you want to do:");
        int selector = scanner.nextInt();
        switch (selector) {
            case 1:
                showObligations(derivativeSevice.getObligations());
                break;
            case 2:
                sortObligations();
                break;
            case 3:
                findByParameters();
        }
        return selector;
    }

    private void showObligations(Obligation[] obligations) {
        String res="\n";
        for (Obligation obligation:obligations) {
            res+=obligation+"\n";
        }
        System.out.println(res);
    }

    private void sortObligations() {
        derivativeSevice.sortByRisk();
        System.out.println("Sorted\n");
    }

    private void findByParameters() {
        int selector;
        do {
            System.out.println("\nFind by:\n" +
                    "1. Risks\n" +
                    "2. Payout amounts");
            System.out.println("\nEnter what you want to do:");
            selector = scanner.nextInt();
            switch (selector) {
                case 1:
                    findByRisk();
                    break;
                case 2:
                    findByPayoutAmount();
            }
        } while (selector < 1 || selector > 2);
    }

    private void findByRisk() {
        System.out.println("Write start value:");
        float start = scanner.nextFloat();
        System.out.println("Write end value:");
        float end = scanner.nextFloat();
        showObligations(derivativeSevice.findByRiskRange(start,end));
    }

    private void findByPayoutAmount() {
        System.out.println("Write start value:");
        double start = scanner.nextDouble();
        System.out.println("Write end value:");
        double end = scanner.nextDouble();
        showObligations(derivativeSevice.findByPayoutAmountRange(start,end));
    }


}
