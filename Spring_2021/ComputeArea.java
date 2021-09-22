
/*
 * Author: Ian Drake
 * FileName: ComputeArea.java
 * Date: 1/26/2021
 * Program to calculate area of a circle given the radius
*/

import java.util.Scanner;

public class ComputeArea {

	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
	
		double radius;  //declare radius
		double area;	//declare area
	
        //ask user for radius
        System.out.print("Enter a number for radius: ");
		radius = input.nextDouble();
	
		//compute area
		area = radius * radius * 3.14159;
		
		//show results
		System.out.println("The area for the circle of radius " + radius + " is "+area);
	}
}
