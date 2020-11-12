package com.step.director;

import com.step.employee.Employee;
import java.util.Scanner;

public class Director {
    private static Scanner sc = new Scanner(System.in);

    private static Employee[]  employees;

    /*----------------------------------------------------------------------------------*/
//  This method creates an array of Employees
    protected static void createCompany(){
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
            employees = (Employee[])resizeArray(employees, employees.length+(employees.length/2) );
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
    private static Object resizeArray (Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0)
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        return newArray;
    }

}
