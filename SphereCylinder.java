/*
* Ian Drake
* 2/11 10:00 AM
* Sphere Cylinder
* This program will prompt the user for 2 inputs, then based on those inputs, either caclulate the volume or surface area based on 
* what the user wants for either a sphere or cylinder. It will then calculate and print the answer.
*/
import java.util.Scanner;

public class SphereCylinder {
    
    public static void main(String[]args){

        Scanner input = new Scanner(System.in);//is used to accept user input and transfer data to a variable
        double radius, height, result; //radius is used for equation of sphere or cylinder, height is used for cylinder's equation, result is used ot make the print out look better.
        int shapeChoice, calcChoice; //shapeChoice and calcChoice are used for the calculation to know what formula to use 

        height = 0; //fixes scope issue with variable at lines 90, 99
        shapeChoice = 0; //scope fix

        //User input section

        //ask user to input the number 1 for a sphere or 2 for a cylinder
        System.out.print("Choose shape: Sphere(1), Cylinder(2)... ");

        shapeChoice = input.nextInt();

        System.out.println("Please enter the number 1 or 2.");

         while(shapeChoice < 1 || shapeChoice > 2){

             if(shapeChoice != 1 || shapeChoice != 2){
                 System.out.print("Please enter a valid number, type 1 for Sphere or type 2 for Cylinder... ");
                shapeChoice = input.nextInt();
            }

         }

        
        //ask user to input the number 1 for input or 2 for surface area
        System.out.print("Choose calculation: Volume(1), Surface Area(2)... ");
        calcChoice = input.nextInt();

        while(calcChoice < 1 || calcChoice > 2){

            if(calcChoice != 1 || calcChoice != 2){
                System.out.print("Please enter a valid number, type 1 for volume or type 2 for surface area... ");
                calcChoice = input.nextInt();
            }

        }

        //ask for radius for sphere
        if(shapeChoice == 1){

            System.out.print("Enter Radius... ");
            radius = input.nextDouble();
        }
            else {

                System.out.print("Enter Radius... ");
                radius = input.nextDouble();

                System.out.print("Enter Height... ");
                height = input.nextDouble();
            }

        //Calculation and Print Out Section
        //4 x Math.PI x radius^2 (Sphere area formula)
        //1.333333333 x Math.PI x radius^3 (Sphere volume formula)
        //2 x Math.PI × radius^2 + 2 × Math.PI × radius × height (Cylinder complete area formula)
        //Math.PI x radius^2 x height (Cylinder volume formula)

        //NOTE: (4/3) is replaced by 1.333333333 in order to assure the closest to a correct answer

        if (shapeChoice == 1 && calcChoice == 1){

            result = 1.333333333 * Math.PI * Math.pow(radius, 3); //(sphere volume)

            System.out.printf("Your answer is... %.4f", result);//format to 4 decimal places
        }

                if (shapeChoice == 1 && calcChoice == 2){

                    result = 4 * Math.PI * Math.pow(radius, 2); //(sphere area)

                    System.out.printf("Your answer is... %.4f", result);//format to 4 decimal places
                }

                else {

                    if (shapeChoice == 2 && calcChoice == 1){

                        result = Math.PI * Math.pow(radius, 2) * height; //cylinder volume

                        System.out.printf("Your answer is... %.4f", result );//format to 4 decimal places
                    }
    
                    else {

                        if ( shapeChoice == 2 && calcChoice == 2){

                            result = (2 * Math.PI * Math.pow(radius, 2) + 2) * Math.PI * radius * height; //(cylinder area)

                             System.out.printf("Your answer is... %.4f", result ); //format to 4 decimal places
                        }
                    }
                }
    }
}
