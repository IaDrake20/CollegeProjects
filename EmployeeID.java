/*
* Ian Drake
* 2/25
* EmployeeID
* An employee will input their last name, month of birth (three letter abbreviation), department (three letter abbreviation).
* The program will then display the employee's ID.
*/

import java.util.Scanner;

//note: DO NOT USE IF STATEMENTS, ONLY SWITCH STATEMENTS
public class EmployeeID {
    
    public static void main(String[]args){

        Scanner input = new Scanner(System.in);//is used to accept user input and transfer data to a variable

        String employeeLastName, department, birthMonth; //places to store the inputed data of the last name, dept., and date of birth
        String lastNamePrint, deptPrint, birhtMonthPrint, nameLengthPrint; //different sections of the employee ID for the print statement

        //fix scope issues
        lastNamePrint = "";
        deptPrint = "";
        birhtMonthPrint = "";
        nameLengthPrint = "";

        //Recieve input from user
        System.out.print("Please type in your last name... ");
        employeeLastName = input.nextLine();

        System.out.print("Please type a three letter abbreviation of the month you were born... ");
        birthMonth = input.nextLine().toLowerCase();
        System.out.println(birthMonth);
        
        System.out.print("Please type in a three letter abbreviation of your department... ");
        department = input.nextLine().toLowerCase();
        System.out.println(department);

        //making ID
        switch(employeeLastName.valueOf(employeeLastName.charAt(0))){

            case "a" : lastNamePrint = "V";
                        break;
            case "e" : lastNamePrint = "V";
                        break;
            case "i" : lastNamePrint = "V";
                        break;
            case "o" : lastNamePrint = "V";
                        break;
            case "u" : lastNamePrint = "V";
                        break;
            default: lastNamePrint = "C";
        }

        switch (department) {

            case "acc": deptPrint = "101";
                        break;
            case "hrs": deptPrint = "102";
                        break;
            case "sal": deptPrint = "103";
                        break;
            case "fin": deptPrint = "104";
                        break;
            case "adv": deptPrint = "105";
                        break;
            case "com": deptPrint = "106";
                        break;
            default:    deptPrint = "110";
                        break;
        }

        switch (birthMonth) {

            case "jan": birhtMonthPrint = "01";
                        break;
            case "feb": birhtMonthPrint = "01";
                        break;
            case "mar": birhtMonthPrint = "02";
                        break;
            case "apr": birhtMonthPrint = "02";
                        break;
            case "may": birhtMonthPrint = "03";
                        break;
            case "jun": birhtMonthPrint = "03";
                        break;
            case "jul": birhtMonthPrint = "04";
                        break;
            case "aug": birhtMonthPrint = "04";
                        break;
            case "sep": birhtMonthPrint = "05";
                        break;
            case "oct": birhtMonthPrint = "05";
                        break;
            case "nov": birhtMonthPrint = "06";
                        break;
            case "dec": birhtMonthPrint = "06";
                        break;            
            default:    nameLengthPrint = "00";
                        break;
        }

        nameLengthPrint = nameLengthPrint.valueOf(employeeLastName.length());        

        System.out.println("Your employee ID is "+lastNamePrint+deptPrint+birhtMonthPrint+nameLengthPrint);



    }
}
