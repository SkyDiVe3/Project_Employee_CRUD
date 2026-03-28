package com.step.director;

import com.step.employee.Employee;

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
        System.out.println("*************************");
        System.out.println("Choose what you want to edit for this employee:");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Address");
        System.out.println("4. Telephone");
        System.out.println("5. Birthdate");
        System.out.println("6. Email");
        System.out.println("7. IDNP");
        System.out.println("8. Exit");
        System.out.println("*************************");
        while(editing){
            System.out.print("Insert -->");
            switch (sc.nextInt()){
                case 1: {
                    employees[id].setFirstname(switchEditShow("firstname")) ;
                    System.out.println("Changed successfully");
                    break;
                }
                case 2: {
                    employees[id].setLastname(switchEditShow("lastname")) ;
                    System.out.println("Changed successfully");
                    break;
                }
                case 3: {
                    employees[id].setAddress(switchEditShow("address")) ;
                    System.out.println("Changed successfully");
                    break;
                }
                case 4: {
                    employees[id].setTelephone(switchEditShow("telephone")) ;
                    System.out.println("Changed successfully");
                    break;
                }
                case 5: {
                    employees[id].setDateOfBirth(switchEditShow("birthdate")) ;
                    System.out.println("Changed successfully");
                    break;
                }
                case 6: {
                    employees[id].setEmail(switchEditShow("email")) ;
                    System.out.println("Changed successfully");
                    break;
                }
                case 7: {
                    employees[id].setIDNP(switchEditShow("IDNP")) ;
                    System.out.println("Changed successfully");
                    break;
                }
                case 8:{
                    System.out.println("|Completed editing|");
                    System.out.println("  |Exit to main|");
                    editing = false;
                    break;
                }
                default: {
                    System.out.println("Invalid option. Please choose 1-8.");
                }
            }
        }
    }
    private static String  switchEditShow(String info){
        String editResult;
        System.out.print("New " + info + " = ");
        sc.nextLine(); // consume leftover newline from previous nextInt()
        editResult = sc.nextLine();
        return editResult;
    }
    /*----------------------------------------------------------------------------------*/
    /**This method removes an employee by their array ID and compacts the array */
    public static void removeEmployee(int id) {
        if (id < 0 || id >= employees.length || employees[id] == null) {
            System.out.println("No employee found with ID: " + id);
            return;
        }
        for (int i = id; i < employees.length - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[employees.length - 1] = null;
        System.out.println("Employee deleted successfully.");
    }
    /*----------------------------------------------------------------------------------*/
    /**This method removes all employees whose first name matches the given name */
    public static void removeEmployee(String name) {
        boolean found = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFirstname().equalsIgnoreCase(name)) {
                for (int j = i; j < employees.length - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[employees.length - 1] = null;
                found = true;
                i--; // re-check same index after shift
            }
        }
        if (!found) System.out.println("No employee found with name: " + name);
        else System.out.println("Employee(s) deleted successfully.");
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
        boolean full = lastAddedEmployee() >= employees.length;
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

}
