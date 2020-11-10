package com.step.director;

import java.util.Scanner;

    public class ManageEmployee extends Director {
        private static Scanner sc = new Scanner(System.in);



        public static void newEmployee(){
            if (isEmptyCompany()) createCompany();

            addEmployee();


        }

        public static void showAllEmployees(){

        }


    }
