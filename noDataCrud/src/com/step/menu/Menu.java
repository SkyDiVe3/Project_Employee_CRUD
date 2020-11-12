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
            case 1 : addEmployeeMenu();
            case 2 :
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
            case 1 : ManageEmployee.newEmployee();
            case 2 :
            case 3 :
            case 4 :
            case 5 : startMenu(); break;
        }
    }
}
