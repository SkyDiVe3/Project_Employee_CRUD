package com.step.director;

import com.step.employee.Employee;
import java.util.Scanner;

public class Director {
    private static Scanner sc = new Scanner(System.in);

    private static Employee[]  employees;

    /*----------------------------------------------------------------------------------*/
//  This method creates an array of Employees
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
    public static void getOneEmployee(String name){

        for (int element = 0; element < employees.length; element++ ){

            if (employees[element] != null && employees[element].getFirstname().equals(name)){
                System.out.println("Employee " + "№" + element);
                employees[element].getCV();
                System.out.println("********************");
            }

        }

    }
    /*----------------------------------------------------------------------------------*/
    public static void getOneEmployee(int id){

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
    public static boolean isEmptyCompany(){
        if (employees == null){
            return true;
        }else return employees.length == 0;
    }
    /*----------------------------------------------------------------------------------*/
//    This method verify if the array of employees is full, if it's full
//    then its called resizeArray method to expand it
    private static void isFullCompany(){
        boolean full = employees.length - (1 + lastAddedEmployee()) == 1;
        if(full){
//            Increasing array by 50%
            employees = resizeArray(employees);
        }
    }
    /*----------------------------------------------------------------------------------*/
//     This method returns index of last added employee in company
    private static int lastAddedEmployee(){
        int x = 0;
        while (x < employees.length) {
            if(employees[x] != null) x++;
            else break;
        }
        return x;
    }
    /*----------------------------------------------------------------------------------*/
    private static Employee[] resizeArray (Employee [] array) {
            int oldLength = array.length;
            int newLength = array.length + (array.length / 2);
            Employee[] empty = new Employee[newLength];
        for (int i = 0; i < array.length; i++) {
            empty[i] = array[i];
        }
        return empty;
    }

}
