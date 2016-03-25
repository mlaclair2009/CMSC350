package project1;

import java.util.EmptyStackException;

public class QueueUMUC <T> {
	
	T[] a;
    int n, front, rear, numItems = 0;
    
    //Size of queue
    int size() {
       return n;}

    //Create new queue
    QueueUMUC(int max) {	  
		a = (T[]) new Object[max]; 
    }
    
    //Add item to the queue
	void enqueue (T x){
		if (isFull()) {
			throw new IndexOutOfBoundsException();
		} else {
		a[rear] = x;
		rear++;
		numItems++;
		System.out.println (x + "  was added to the queue.");
		}
    } 
	
	//Remove item from the queue
	T dequeue(){
		if (isEmpty()){
			throw new EmptyStackException();
		} else {
			System.out.println (a[front] + " was removed from the queue.");
			a[front] = null;
			front ++;
			numItems--;
			return null;
		}
	}
	
	//Peek displays item in the front of the queue
	T peek () {
		if (isEmpty()){
			throw new EmptyStackException();
		} else {
		System.out.println(a[front] + " is at the front of the queue!");
		return null;
		}
	}
	
	//Checks to see if queue is full
	Boolean isFull() {
		if (numItems + 1 < size()){
			return true;
		}
		else {
		return false;
		}
	}
	
	//Checks to see if queue is empty
	Boolean isEmpty() {
		if (numItems < 1){
			return true;
		}
		else {
		return false;
		}
	}
	
	//Converts integer to string and displays
	public String toString(){
		if (isEmpty()){
			throw new EmptyStackException();	
		}else{
			System.out.println (a[front].toString() + " is at the front of the queue. (String Version)");
		}
		return null;
	}
	
	//Displays all items in the queue
    void display(){
        for (int i = 0; i < a.length; i++)
        	if (isEmpty()){
        		throw new EmptyStackException();
        	} else {
            System.out.print(a[i] + " ");
        	}
         System.out.println();
     }
    	
    }
