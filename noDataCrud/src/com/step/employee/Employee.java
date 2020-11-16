    package com.step.employee;

    import java.util.Scanner;
    import java.time.LocalDate;
    public class Employee {
            private static Scanner sc = new Scanner(System.in);

            private String[] CV = new String[7];
            private String Firstname;
            private String Lastname;
            private String Address;
            private String Telephone;
            private String DateOfBirth;
            private String Email;
            private String IDNP;

        public void setLastname(String lastname) {
            Lastname = lastname;
        }

        public void setFirstname(String firstname) {
            Firstname = firstname;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public void setTelephone(String telephone) {
            Telephone = telephone;
        }

        public void setDateOfBirth(String dateOfBirth) {
            DateOfBirth = dateOfBirth;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public void setIDNP(String IDNP) {
            this.IDNP = IDNP;
        }

/******************************************************/

        public String getLastname() {
            return Lastname;
        }

        public String getFirstname() {
            return Firstname;
        }

        public String getAddress() {
            return Address;
        }

        public String getTelephone() {
            return Telephone;
        }

        public String getDateOfBirth() {
            return DateOfBirth;
        }

        public String getEmail() {
            return Email;
        }

        public String getIDNP() {
            return IDNP;
        }

        /** Constructor */
            public Employee(){

                setCV();

            }

        /** Setter for CV*/
            private void setCV() {

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
                        case 0:System.out.println('1' + " Name =" + this.Firstname); break;
                        case 1:System.out.println('2' + " Lastname =" +this.Lastname); break;
                        case 2:System.out.println('3' + " Address =" +this.Address); break;
                        case 3:System.out.println('4' + " Telephone =" +this.Telephone); break;
                        case 4:System.out.println('5' + " Birthdate =" +this.DateOfBirth); break;
                        case 5:System.out.println('6' + " Email =" +this.Email); break;
                        case 6:System.out.println('7' + " IDNP =" +this.IDNP); break;
                    }
                }
            }


    }
