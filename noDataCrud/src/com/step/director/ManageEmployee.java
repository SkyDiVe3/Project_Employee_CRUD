package com.step.director;

import java.util.Scanner;

    public class ManageEmployee extends Director {
        private static Scanner sc = new Scanner(System.in);



        public static void newEmployee(){
            if (isEmptyCompany()) createCompany();

            addEmployee();


        }

        public static boolean showEmployees(int selection){
            if(isEmptyCompany() && selection !=4){
                System.out.println("Your company is empty");
                System.out.println("Please create a company and add some employees");
                System.out.println("-------------------------");
                System.out.println("Press enter to continue");
                sc.nextByte();
                return false;
            }
            else{
                System.out.println("|SHOWING EMPLOYEES|");
                switch (selection){
                    case 1 : {
                        getAllEmployees();
                        return true;
                    }
                    case 2 : {
                        System.out.print("Insert name --->");
                        getEmployee(sc.nextLine());
                        return true;
                    }
                    case 3 :{
                        System.out.print("Insert ID --->");
                        getEmployee(sc.nextInt());
                        return true;
                    }
                    case 4 :{
                        return true;

                    }
                    default: return true;
                }

            }

        }

        public static boolean getEditEmployee(int selection){
            if (isEmptyCompany() && selection != 2){
              System.out.println("Your company is empty");
              System.out.println("Please create a company and add some employees");
              System.out.println("-------------------------");
              System.out.println("Press enter to continue");
              sc.next();
              return false;
            }
            else{
              switch (selection){
                  case 1: {
                     int id;
                      System.out.println("|SEARCH EMPLOYEE TO MODIFY|");
                      System.out.print("Insert employee ID --->");
                      id = sc.nextInt();
                      getEmployee(id);
                      setEditEmployee(id);
                      return true;
                  }
                  case 2:{
                      return true;
                  }
                  default:return true;
              }

            }

            
        }
    }
