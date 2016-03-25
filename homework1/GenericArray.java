package homework1;

import java.util.Arrays;
import java.util.Scanner;

public class GenericArray <E> {     
	   private E [] array;     
	   private int size;
	  
	   class arrCreate{
		   
	   //Default array constructor
	   arrCreate() {	  
	      array = (E[]) new Object[10]; 
	      size = 0;
	   }

	   //Custom sized array constructor
	   arrCreate(int numElements){
		   array = (E[]) new Object[numElements];
		   size = 0;
	   }
	}
	
	   public E get(int i) { 
	      return array[i];
	   }
	   
	   public void set(int i, E value) {
	      array[i-1] = value;
	      display();
	   }
	   
	   //Add function will now create extra elements if size exceeded
	   public void add(E value) {
		   if (isFull()){
				E[] tempArr = Arrays.copyOf(array, array.length + 1 );
				array = tempArr;
				array[size++] = value;
		   } else {
	      array[size++] = value;
		   }
		   display();
	   }
	   
	   public boolean isFull(){
	      return  size == array.length;
	   }
	   
	   public void remove(int i) {
	      for (int j = i; j < size; j++)
	          array[j] = array[j+1];
	      size--;
	      display();
	   }
	   
	   //Insert function will now create extra elements if size exceeded
	   public void insert (int i, E value) {
		   if (isFull() | i > array.length ){
			   	int diff = i - array.length;
				E[] tempArr = Arrays.copyOf(array, array.length + diff );
				array = tempArr;
				array[i-1] = value;
				}
		   else {
			    array[i-1] = value;	
			    }
			display();
				}
	   
	   //Method will reverse elements in array
	   public void reverse (){
		   for (int i = 0; i < array.length/2; i++){
		        E temp = array[i];
		        array[i] = array[array.length - i - 1];
		        array[array.length - i - 1] = temp;
		   }
		   display();
	   }
	   
	   public void display() {
	      for (int i = 0; i < array.length; i++)
	         System.out.print(array[i] + " ");
	      System.out.println();
	   }
	  
	   //Menu options for user selection
	   public int menu (){
			// Create Scanner
			Scanner input = new Scanner (System.in);
			int selection;
			//Display menu
			System.out.print ("\n1 - Custom Array Size");
			System.out.print ("\n2 - Default Array Size (10)");
			System.out.print ("\n3 - Add Item to Array");
			System.out.print ("\n4 - Remove Item from Array");
			System.out.print ("\n5 - Set Item in Array");
			System.out.print ("\n6 - Reverse Array Items");
			System.out.print ("\n7 - Display Array Items");
			System.out.print ("\n8 - Insert Item to Array");
			System.out.print ("\n9 - Exit");
			
			// Prompt User for Menu Selection
			System.out.print ("\nPlease Choose a Menu Item: ");
			selection = input.nextInt();
			
			// Determine if Incorrect Number Was Entered. Exit program if so.
			if (selection > 9){
				System.out.print ("Your selection was invalid. Please start over. ");
			System.exit (0);
			}
			return selection;	
			}
	  
	  //User choice will initialize appropriate method
	  public void choice (int selection){
		  Scanner input = new Scanner (System.in);
		
		if (selection == 1){
			System.out.println("Please enter array size: ");
			int num = input.nextInt();
			arrCreate arrCustom = new arrCreate(num);
			display();
			}
		
		else if (selection == 2) {
			arrCreate arrDefault = new arrCreate();
			display();
			}
		
		else if (selection == 3) {
			System.out.println("Please enter the value you wish to enter into this array: ");
			E value = (E) input.next();
			add(value);
			}
		
		else if (selection == 4) {
			System.out.println("Please enter the element number you wish to remove: ");
			int num = input.nextInt();
			remove(num);
			}
		
		else if (selection == 5) {
			System.out.println("Please enter the element you wish to input to: ");
			int num = input.nextInt();
			System.out.println("Please enter the value you wish to input: ");
			E value = (E) input.next();
			set(num,value);
			}
		
		else if (selection == 6) {
			System.out.println("Array is being reversed...");
			reverse();
			}
		
		else if (selection == 7) {
			display();
		    }
		
		else if (selection == 8) {
			System.out.println("Please enter the element you wish to input to: ");
			int num = input.nextInt();
			System.out.println("Please enter the value you wish to input: ");
			E value = (E) input.next();
			insert(num,value);
		}
		
		else if (selection == 9){
			System.out.println("Thank you for using this program!");
			System.exit (0);
		}
	}
 }


