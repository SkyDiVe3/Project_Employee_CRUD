    package com.step.employee;

    import java.util.Scanner;
    import java.time.LocalDate;
    public class Employee {
            private static Scanner sc = new Scanner(System.in);

            private String[] CV = new String[7];
            private String Lastname;
            private String Firstname;
            private String Address;
            private String Telephone;
            private String DateOfBirth;
            private String Email;
            private String IDNP;



            public Employee(){

                setCV();

            }

            private  void  setCV() {

                    for (int x = 0;x < 7; x++){
                        switch (x){
                            case 0:System.out.println("Enter Name:"); CV[x] = sc.nextLine(); break;
                            case 1:System.out.println("Enter Surname:"); CV[x] = sc.nextLine(); break;
                            case 2:System.out.println("Enter Address:"); CV[x] = sc.nextLine(); break;
                            case 3:System.out.println("Enter Phone:"); CV[x] = sc.nextLine(); break;
                            case 4:System.out.println("Enter Birthdate:"); CV[x] = sc.nextLine(); break;
                            case 5:System.out.println("Enter Email:"); CV[x] = sc.nextLine(); break;
                            case 6:System.out.println("Enter IDNP:"); CV[x] = sc.nextLine(); break;
                        }
                    }

                for(int x = 0;x < 7; x++){
                    switch (x){
                        case 0:this.Firstname = CV[x]; break;
                        case 1:this.Lastname = CV[x]; break;
                        case 2:this.Address = CV[x]; break;
                        case 3:this.Telephone = CV[x]; break;
                        case 4:this.DateOfBirth = CV[x]; break;
                        case 5:this.Email = CV[x]; break;
                        case 6:this.IDNP = CV[x]; break;
                    }
                }

            }
            public void getCV(){
                for(int x = 0;x < 7; x++){
                    switch (x){
                        case 0:System.out.println(this.Firstname); break;
                        case 1:System.out.println(this.Lastname); break;
                        case 2:System.out.println(this.Address); break;
                        case 3:System.out.println(this.Telephone); break;
                        case 4:System.out.println(this.DateOfBirth); break;
                        case 5:System.out.println(this.Email); break;
                        case 6:System.out.println(this.IDNP); break;
                    }
                }
            }


    }
