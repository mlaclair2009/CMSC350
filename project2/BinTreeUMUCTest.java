package project2;

import java.util.Scanner;

public class BinTreeUMUCTest {

	public static void main(String[] args) {
		
		BinTreeUMUC <String> test = new BinTreeUMUC <String>();

		Scanner input = new Scanner (System.in);
		int selection = 0;
		
		while (selection !=11){
			
		//Display menu
		System.out.println ("1 - Enter Input File Name");
		System.out.println ("2 - toPreOrderString");
		System.out.println ("3 - toInOrderString");
		System.out.println ("4 - toInPostOrderString");
		System.out.println ("5 - toLevelOrderString");
		System.out.println ("6 - countNodes");
		System.out.println ("7 - countLeafs");
		System.out.println ("8 - countLeft");
		System.out.println ("9 - countRight");
		System.out.println ("10 - countNodesLevel");
		System.out.println ("11 - Exit");
		System.out.println ("Please choose a menu item: ");
		selection = input.nextInt();
		
		if (selection == 1){
			System.out.println("Please enter a file name (numbers.txt): ");
			String word = input.next();
			test.BinTreeUMUC(word);
			}
		
		else if (selection == 2) {
			test.toPreOrderString();
			}
		
		else if (selection == 3) {
			test.toInOrderString();
			}
		
		else if (selection == 4) {
			test.toPostOrderString();
			}
		
		else if (selection == 5) {
			test.toLevelOrderString();
			}
		
		else if (selection == 6) {
			test.countNodes();
			}
		
		else if (selection == 7){
			test.countLeafs();
			}
		
		else if (selection == 8){
			test.countLeft();
			}
		
		else if (selection == 9){
			test.countRight();
			}
		
		else if (selection == 10) {
			test.countNodesLevel();
			}
		
		else if (selection == 11) {
			System.out.println("Thank you for using this program!");
			System.exit (0);
			}
		
		else if (selection > 11 || selection < 1){
			System.out.print ("Your selection was invalid. Please start over. ");
			throw new IndexOutOfBoundsException();
		}
	}
}

}

