package com.step.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.step.director.ManageEmployee;
public class Menu {
    private static Scanner input = new Scanner(System.in);
    private final static String[]  mainMenu = new String[]{"Create","Read","Edit","Delete"};

    public static void startMenu() {
        int selection;

        /**************************************************/
        for(int n = 0; n < 10; n++ ){
            System.out.println();
        }
        System.out.println("      |MAIN  MENU|");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------1");
        for (int element = 0; element < mainMenu.length; element++){
            System.out.println(element+1 + " - " + mainMenu[element] + " employees");
        }
        System.out.println("5 - Quit");
        System.out.print("INSERT--->");
        try {
            selection = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
            startMenu();
            return;
        }
        switch (selection){
            case 1 : addEmployeeMenu(); break;
            case 2 : readEmployeeMenu(); break;
            case 3 : editEmployeeMenu(); break;
            case 4 : deleteEmployeeMenu(); break;
            case 5 :  break;
            default: {
                System.out.println("Invalid option. Please choose 1-5.");
                startMenu();
            }
        }

    }

    protected static void addEmployeeMenu(){
        int selection;

        for(int n = 0; n < 10; n++ ){
            System.out.println();
        }

        System.out.println(" |CREATING EMPLOYEE MENU|");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------");
        System.out.println("1 - Add new Employee");
        System.out.println("5 - Back");
        System.out.print("INSERT--->");

        try {
            selection = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
            addEmployeeMenu();
            return;
        }

        switch (selection){
            case 1 : {
                ManageEmployee.newEmployee();
                System.out.println("Employee adding success");
                addEmployeeMenu();
                break;
            }
            case 5 : startMenu(); break;
            default: {
                System.out.println("Invalid option.");
                addEmployeeMenu();
            }
        }
    }

    protected static void readEmployeeMenu(){
        int selection;
        boolean step;

        for(int n = 0; n < 10; n++ ){
            System.out.println();
        }

        System.out.println(" |READING EMPLOYEE MENU|");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------");
        System.out.println("1 - READ ALL EMPLOYEES");
        System.out.println("2 - READ AN EMPLOYEE BY NAME");
        System.out.println("3 - READ AN EMPLOYEE BY ID");
        System.out.println("4 - Back");
        System.out.print("INSERT--->");

        try {
            selection = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
            readEmployeeMenu();
            return;
        }

        step=ManageEmployee.showEmployees(selection);

        if (step == false) addEmployeeMenu();
        else {
            System.out.println("Press enter to continue");
            input.next();
            startMenu();
        }

    }

    protected static void editEmployeeMenu(){
        int selection;
        boolean step;
        for(int n = 0; n < 10; n++ ){
            System.out.println();
        }

        System.out.println(" |EDITING EMPLOYEE MENU|");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------");
        System.out.println("1 - MODIFY EMPLOYEE BY ID ");
        System.out.println("2 - BACK");

        System.out.print("INSERT--->");
        try {
            selection = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
            editEmployeeMenu();
            return;
        }
        step=ManageEmployee.getEditEmployee(selection);
        if (step == false) addEmployeeMenu();
        else {
            System.out.println("Press enter to continue");
            input.next();
            startMenu();
        }
    }

    protected static void deleteEmployeeMenu(){
        int selection;
        boolean step;
        for(int n = 0; n < 10; n++ ){
            System.out.println();
        }

        System.out.println(" |DELETING EMPLOYEE MENU|");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------");
        System.out.println("1 - DELETE EMPLOYEE BY ID");
        System.out.println("2 - DELETE EMPLOYEE BY NAME");
        System.out.println("3 - BACK");

        System.out.print("INSERT--->");
        try {
            selection = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
            deleteEmployeeMenu();
            return;
        }
        step = ManageEmployee.getDeleteEmployee(selection);
        if (step == false) deleteEmployeeMenu();
        else {
            System.out.println("Press enter to continue");
            input.next();
            startMenu();
        }
    }
}
