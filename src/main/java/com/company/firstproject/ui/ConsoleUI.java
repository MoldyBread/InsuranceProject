package com.company.firstproject.ui;

import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.service.DerivativeService;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleUI {

    private DerivativeService derivativeService;
    private Scanner scanner;
    private ResourceBundle bundle = ResourceBundle.getBundle("MenuBundle", Locale.US);

    public ConsoleUI(DerivativeService derivativeService){
        this.derivativeService = derivativeService;
        scanner = new Scanner(System.in);

    }

    public void run(){
        if(derivativeService.getObligations().size()!=0){
            menu();
        }
        else {
            System.out.println("Nothing in derivative");
        }
    }

    public void menu()  {
        int state;
        System.out.println("Hello, this is my console app project.\n");



        int selector;
        do {
            System.out.println("Choose language\n1. ru\n2. en");
            selector = scanner.nextInt();
            if(selector==1){
                bundle = ResourceBundle.getBundle("MenuBundle", new Locale("ru","RU"));
            }
        } while (selector < 1 || selector > 2);


        while (true) {
            state = menuRunner();
            if (state == 4) {
                break;
            }
            if (state > 4 || state < 0) {
                System.out.println(bundle.getString("wronginput"));
            }
        }
    }

    private int menuRunner() {
        System.out.println(bundle.getString("menu"));
        int selector = scanner.nextInt();
        switch (selector) {
            case 1:
                showObligations(derivativeService.getObligations());
                break;
            case 2:
                sortObligations();
                break;
            case 3:
                findByParameters();
        }
        return selector;
    }

    private void showObligations(List<Obligation> obligations) {
        String res = "\n";
        for (Obligation obligation : obligations) {
            res += obligation + "\n";
        }
        System.out.println(res);
    }

    private void sortObligations() {
        derivativeService.sortByRisk();
        System.out.println(bundle.getString("sorted"));
    }

    private void findByParameters() {
        int selector;
        do {
            System.out.println(bundle.getString("findbyparameters"));
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
        System.out.println(bundle.getString("startvalue"));
        double start = scanner.nextDouble();
        System.out.println(bundle.getString("endvalue"));
        double end = scanner.nextDouble();
        showObligations(derivativeService.findByRiskRange(start, end));
    }

    private void findByPayoutAmount() {
        System.out.println(bundle.getString("startvalue"));
        double start = scanner.nextDouble();
        System.out.println(bundle.getString("endvalue"));
        double end = scanner.nextDouble();
        showObligations(derivativeService.findByPayoutAmountRange(start, end));
    }


}
