package project1;

import java.util.EmptyStackException;

public class StackUMUC <T> {
	
	T[] a;
    int n;
    
    //Size of stack
    int size() {
       return n;}
    
    //Track element of top of stack
    int topOfStack = -1;
    
    //Create new stack using user input
    StackUMUC(int max) {	  
		a = (T[]) new Object[max]; 
    }
    
	    //Push adds input to top of stack
		void push (T x){
			if (isFull()) {
				throw new IndexOutOfBoundsException();
			} else {
			topOfStack++;
			a[topOfStack] = x;
			System.out.println (x + "  was added to the stack.");
			}
	    }
		
		//Pop removes last input from stack
		T pop (){
			if (isEmpty()){
				throw new EmptyStackException();
			} else{
				System.out.println (a[topOfStack] + " was removed from the stack.");
				a[topOfStack] = null;
				return a[topOfStack--];
			}
		}
		
		//Peek displays item in top of stack
		T peek () {
			if (isEmpty()){
				throw new EmptyStackException();
			} else {
			System.out.println(a[topOfStack] + " is at the top of the stack!");
			return null;
			}
		}
		
		//Converts integer to string and displays
		public String toString(){
			if (isEmpty()){
				throw new EmptyStackException();	
			}else{
				System.out.println (a[topOfStack].toString() + " is at the top of the stack (String Version)");
			}
			return null;
		}
		
		//Displays all items in list
	    void display(){
	        for (int i = 0; i < a.length; i++)
	        	if (isEmpty()){
	        		throw new EmptyStackException();
	        	} else {
	            System.out.print(a[i] + " ");
	        	}
	         System.out.println();
	     }
		
		//Checks to see if stack is full
		Boolean isFull() {
			if (topOfStack + 1 < size()){
				return true;
			}
			else {
			return false;
			}
		}
		
		//Checks to see if stack is empty
		Boolean isEmpty() {
			if (topOfStack < 0){
				return true;
			}
			else {
			return false;
			}
			
		}
	}
