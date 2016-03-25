package project3;

import java.util.Scanner;

import org.junit.Test;

public class Project3Test {

	@Test
	public void test() {

			Project3 test = new Project3 ();
			
			Scanner input = new Scanner (System.in);
			int selection = 0;
			test.createArray();
			
			while (selection !=8){
				
			//Display menu
			System.out.println ("1 - Show Original Array");
			System.out.println ("2 - QuickSort - Show True");
			System.out.println ("3 - QuickSortOpt1 - Show True");
			System.out.println ("4 - QuickSortOpt2 - Show True");
			System.out.println ("5 - QuickSort - Show False");
			System.out.println ("6 - QuickSortOpt1 - Show False");
			System.out.println ("7 - QuickSortOpt2 - Show False");
			System.out.println ("8 - Exit");
			System.out.println ("Please choose a menu item: ");
			selection = input.nextInt();
			
			if (selection == 1){
				System.out.println("Original Array:");
				test.show(test.theArray, true);
				}
			
			else if (selection == 2) {
				test.quickSort(test.copy1,0,test.copy1.length-1, true);
				}
			
			else if (selection == 3) {
				test.quickSortOpt1(test.copy2,0, test.copy2.length-1, true);
				}
			
			else if (selection == 4) {
				test.quickSortOpt2(test.copy3, 0, test.copy3.length-1, true);
				}
			
			else if (selection == 5) {
				test.quickSort(test.copy1,0,test.copy1.length-1, false);
				}
			
			else if (selection == 6) {
				test.quickSortOpt1(test.copy2,0, test.copy2.length-1, false);
				}
			
			else if (selection == 7){
				test.quickSortOpt2(test.copy3, 0, test.copy3.length-1, false);
				}
			
			else if (selection == 8){
				System.out.println("Thank you for using this program!");
				System.exit (0);
				}
			
			else if (selection > 8 || selection < 1){
				System.out.print ("Your selection was invalid. Please start over. ");
				throw new IndexOutOfBoundsException();
			}
		}
	}

}