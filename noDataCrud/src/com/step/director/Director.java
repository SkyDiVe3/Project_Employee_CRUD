package com.step.director;

import com.step.employee.Employee;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Director {
    private static Scanner sc = new Scanner(System.in);

    private static Employee[]  employees;

    /*----------------------------------------------------------------------------------*/
    /**  This method creates an array of Employees*/
    public static void createCompany(){
        int nrOfEmployees;
        System.out.println("Enter how many employees you want to have in company:");
        nrOfEmployees = sc.nextInt();
        employees = new Employee[nrOfEmployees];
    }
    /*----------------------------------------------------------------------------------*/
    public static void addEmployee(){
        isFullCompany();
        employees[lastAddedEmployee()]= new Employee();

    }
    /*----------------------------------------------------------------------------------*/
    public static void getEmployee(String name){

        for (int element = 0; element < employees.length; element++ ){

            if (employees[element] != null && employees[element].getFirstname().equals(name)){
                System.out.println("Employee " + "№" + element);
                employees[element].getCV();
                System.out.println("********************");
            }

        }

    }
    /*----------------------------------------------------------------------------------*/
    public static void getEmployee(int id){

        for (int element = 0; element < employees.length; element++ ){

            if (employees[element] != null && element == id){
                System.out.println("Employee " + "№" + element);
                employees[element].getCV();
                System.out.println("********************");
            }

        }

    }
    /*----------------------------------------------------------------------------------*/
    public static void getAllEmployees(){
        for (int element = 0; element < employees.length; element++ ){

            if (employees[element] != null){
                System.out.println("Employee " + "№" + element);
                employees[element].getCV();
                System.out.println("********************");
            }

        }

    }
    /*----------------------------------------------------------------------------------*/
    public static void setEditEmployee(int id) {
        boolean editing = true ;
        System.out.println("8. Exit");
        System.out.println("*************************");
        System.out.println("Choose what you want to edit for this employee");
        while(editing){
            System.out.print("Insert -->");
            switch (sc.nextInt()){
                case 1: {
                    employees[id].setFirstname(switchEditShow("firstname")) ;
                    System.out.println("Changed successfull");
                    sc.nextByte();
                    break;
                }
                case 2: {
                    employees[id].setFirstname(switchEditShow("lastname")) ;
                    break;
                }
                case 3: {
                    employees[id].setFirstname(switchEditShow("address")) ;
                    break;
                }
                case 4: {
                    employees[id].setFirstname(switchEditShow("telephone")) ;
                    break;
                }
                case 5: {
                    employees[id].setFirstname(switchEditShow("birthdate")) ;
                    break;
                }
                case 6: {
                    employees[id].setFirstname(switchEditShow("email")) ;
                    break;
                }
                case 7: {
                    employees[id].setFirstname(switchEditShow("IDNP")) ;
                    break;
                }
                case 8:{
                    System.out.println("|Completed editing|");
                    System.out.println("  |Exit to main|");
                    editing = false;
                }
            }
        }
    }
    private static String  switchEditShow(String info){
        String editResult;
        System.out.print("New " + info + " = ");
        editResult = sc.nextLine();
        return editResult;
    }
    /*----------------------------------------------------------------------------------*/
    public static boolean isEmptyCompany(){
        if (employees == null){
            return true;
        }else return employees.length == 0;
    }
    /*----------------------------------------------------------------------------------*/
    /**This method verify if the array of employees is full, if it's full
    then its called resizeArray method to expand it*/
    private static void isFullCompany(){
        boolean full = employees.length - (1 + lastAddedEmployee()) == 1;
        if(full){
//            Increasing array by 50%
            employees = resizeArray(employees);
        }
    }
    /*----------------------------------------------------------------------------------*/
    /**This method returns index of last added employee in company*/
    private static int lastAddedEmployee(){
        int x = 0;
        while (x < employees.length) {
            if(employees[x] != null) x++;
            else break;
        }
        return x;
    }
    /*----------------------------------------------------------------------------------*/
    /**This method will resize the transmitted array by 50% */
    private static Employee[] resizeArray (Employee [] array) {
            int oldLength = array.length;
            int newLength = array.length + (array.length / 2);
            Employee[] empty = new Employee[newLength];
        for (int i = 0; i < array.length; i++) {
            empty[i] = array[i];
        }
        return empty;
    }
    /*----------------------------------------------------------------------------------*/

    private static int[] searchEmployee(Employee [] employees){
        int searchResults [] = new int[employees.length];

        return searchResults;
    }

}
