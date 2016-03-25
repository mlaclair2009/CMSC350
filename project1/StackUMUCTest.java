package project1;

import java.util.Scanner;

public class StackUMUCTest {

	static int max = 5;
	
	public static void main(String[] args) {
		
		StackUMUC <Integer> list = new StackUMUC <Integer>(max);
		Scanner input = new Scanner (System.in);
		int selection = 0;
		
		while (selection !=6){
		//Display menu
		System.out.print ("\n1 - Push");
		System.out.print ("\n2 - Pop");
		System.out.print ("\n3 - Peek");
		System.out.print ("\n4 - Convert to String");
		System.out.print ("\n5 - Displays All");
		System.out.print ("\n6 - Exit");
		System.out.print ("\nPlease Choose a Menu Item: ");
		selection = input.nextInt();
		
		if (selection == 1){
			System.out.println("Please enter a number: ");
			int num = input.nextInt();
			list.push(num);
			}
		
		else if (selection == 2) {
			list.pop();
			}
		
		else if (selection == 3) {
			list.peek();
			}
		
		else if (selection == 4) {
			list.toString();
			}
		
		else if (selection == 5) {
			list.display();
		}
		
		else if (selection == 6) {
			System.out.println("Thank you for using this program!");
			System.exit (0);
			}
		
		else if (selection > 6 || selection < 1){
			System.out.print ("Your selection was invalid. Please start over. ");
			throw new IndexOutOfBoundsException();
		}
	}

	}

}
