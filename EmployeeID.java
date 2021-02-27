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
        String last_Name_Vowel_or_Consonant_Print, deptPrint, birthMonthPrint, nameLengthPrint; //different sections of the employee ID for the print statement

        //fix scope issues
        last_Name_Vowel_or_Consonant_Print = "";
        deptPrint = "";
        birthMonthPrint = "";
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

            case "a" : last_Name_Vowel_or_Consonant_Print = "V";
                        break;
            case "e" : last_Name_Vowel_or_Consonant_Print = "V";
                        break;
            case "i" : last_Name_Vowel_or_Consonant_Print = "V";
                        break;
            case "o" : last_Name_Vowel_or_Consonant_Print = "V";
                        break;
            case "u" : last_Name_Vowel_or_Consonant_Print = "V";
                        break;
            default: last_Name_Vowel_or_Consonant_Print = "C";
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

            case "jan": birthMonthPrint = "01";
                        break;
            case "feb": birthMonthPrint = "01";
                        break;
            case "mar": birthMonthPrint = "02";
                        break;
            case "apr": birthMonthPrint = "02";
                        break;
            case "may": birthMonthPrint = "03";
                        break;
            case "jun": birthMonthPrint = "03";
                        break;
            case "jul": birthMonthPrint = "04";
                        break;
            case "aug": birthMonthPrint = "04";
                        break;
            case "sep": birthMonthPrint = "05";
                        break;
            case "oct": birthMonthPrint = "05";
                        break;
            case "nov": birthMonthPrint = "06";
                        break;
            case "dec": birthMonthPrint = "06";
                        break;            
            default:    nameLengthPrint = "00";
                        break;
        }

        nameLengthPrint = nameLengthPrint.valueOf(employeeLastName.length());        

        System.out.println("Your employee ID is "+last_Name_Vowel_or_Consonant_Print+deptPrint+birthMonthPrint+nameLengthPrint);

        


    }

    public static void test() {
        last_Name_Vowel_or_Consonant_Print = "C";
        deptPrint = "102";
        birthMonthPrint = "02";
        nameLengthPrint = "05";
        System.out.println("Your employee ID is "+last_Name_Vowel_or_Consonant_Print+deptPrint+birthMonthPrint+nameLengthPrint);

        last_Name_Vowel_or_Consonant_Print = "V";
        deptPrint = "110";
        birthMonthPrint = "06";
        nameLengthPrint = "12";
        System.out.println("Your employee ID is "+last_Name_Vowel_or_Consonant_Print+deptPrint+birthMonthPrint+nameLengthPrint);


    }
}
