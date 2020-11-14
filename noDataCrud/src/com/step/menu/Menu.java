package com.step.menu;

import java.lang.reflect.Array;
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
        selection = input.nextInt();
        switch (selection){
            case 1 : addEmployeeMenu(); break;
            case 2 : readEmployeeMenu(); break;
            case 3 :
            case 4 :
            case 5 :  break;
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

        selection = input.nextInt();

        switch (selection){
            case 1 : {
                ManageEmployee.newEmployee();
                System.out.println("Employee adding success");
                addEmployeeMenu();
                break;
            }
            case 2 :
            case 3 :
            case 4 :
            case 5 : startMenu(); break;
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

        selection = input.nextInt();

        step=ManageEmployee.showEmployees(selection);

        if (step == false) addEmployeeMenu();
        else {
            System.out.println("Press enter to continue");
            input.next();
            readEmployeeMenu();
        }

    }
    protected static void deleteEmployeeMenu(){
        /* Well, you can't really delete an element from an array, like you said.
         * Best you can hope for is to give the removed element a null value instead. Thus leaving it empty.
         * Or, you could alternatively,
         * make a new array with length-1 elements and copy all desired elements to that array. */
    }
}
