package wk2discussion;

import java.util.Scanner;

import org.junit.Test;
public class TestArrayStack {
	public static <T> void main(String[] args)  {
		
		ArrayStack <T> test = new ArrayStack<T> (10);
		
		Scanner input = new Scanner (System.in);
		int selection = 0;
		
		
		while (selection !=5){
		//Display menu
		System.out.print ("\n1 - Add");
		System.out.print ("\n2 - Set");
		System.out.print ("\n3 - Get");
		System.out.print ("\n4 - Remove");
		System.out.print ("\n5 - Exit");
		System.out.print ("\nPlease Choose a Menu Item: ");
		selection = input.nextInt();
		
		if (selection == 1){
			System.out.println("Please enter the element you wish to input to: ");
			int num = input.nextInt();
			System.out.println("Please enter the value you wish to input: ");
			T value = (T) input.next();
			test.add(num,value);
			test.display();
			}
		
		else if (selection == 2) {
			System.out.println("Please enter the element you wish to input to: ");
			int num = input.nextInt();
			System.out.println("Please enter the value you wish to input: ");
			T value = (T) input.next();
			test.set(num,value);
			test.display();
			}
		
		else if (selection == 3) {
			System.out.println("Please enter item number you wish to retrieve: ");
			int num = input.nextInt();
			test.get(num) ;
			}
		
		else if (selection == 4) {
			System.out.println("Please enter the element number you wish to remove: ");
			int num = input.nextInt();
			test.remove(num);
			test.display();
			}
		
		else if (selection == 5) {
			System.out.println("Thank you for using this program!");
			System.exit (0);
			}
		
		else if (selection > 9 || selection < 1){
			System.out.print ("Your selection was invalid. Please start over. ");
			throw new IndexOutOfBoundsException();
		}
	}
}
}
		
		