package homework2;

import java.util.Scanner;

import project1.QueueUMUC;

public class LinkedListUMUCTest {

	public static void main(String[] args) {
		
		LinkedListUMUC <String> test = new LinkedListUMUC <String>();

		Scanner input = new Scanner (System.in);
		int selection = 0;
		
		while (selection !=10){
			
		//Display menu
		System.out.println ("1 - Insert Head");
		System.out.println ("2 - Insert Tail");
		System.out.println ("3 - Remove Head");
		System.out.println ("4 - Remove Tail");
		System.out.println ("5 - Remove Element at Specific Location");
		System.out.println ("6 - View Element at Specific Location");
		System.out.println ("7 - View Head");
		System.out.println ("8 - View Tail");
		System.out.println ("9 - View All");
		System.out.println ("10 - Exit");
		System.out.println ("Please choose a menu item: ");
		selection = input.nextInt();
		
		if (selection == 1){
			System.out.println("Please enter a string: ");
			String word = input.next();
			test.insertHead(word);
			}
		
		else if (selection == 2) {
			System.out.println("Please enter a string: ");
			String word = input.next();
			test.insertTail(word);
			}
		
		else if (selection == 3) {
			test.removeHead();
			}
		
		else if (selection == 4) {
			test.removeTail();
			}
		
		else if (selection == 5) {
			System.out.println("Please enter the element number you wish to remove: ");
			int num = input.nextInt();
			test.removeElementAt(num);;
			}
		
		else if (selection == 6) {
			System.out.println("Please enter the element number you wish to view: ");
			int num = input.nextInt();
			test.peekElementAt(num);;
			}
		
		else if (selection == 7){
			test.peekHead();
			}
		
		else if (selection == 8){
			test.peekTail();
			}
		
		else if (selection == 9){
			test.display();
			}
		
		else if (selection == 10) {
			System.out.println("Thank you for using this program!");
			System.exit (0);
			}
		
		else if (selection > 10 || selection < 1){
			System.out.print ("Your selection was invalid. Please start over. ");
			throw new IndexOutOfBoundsException();
		}
	}
}

}
