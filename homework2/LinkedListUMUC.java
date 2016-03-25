package homework2;

import java.util.EmptyStackException;

public class LinkedListUMUC <T> {
	
	NodeUMUC firstLink;
	NodeUMUC lastLink;
	
	//Insert into first position
	public void insertHead (T value){
		NodeUMUC newLink = new NodeUMUC (value);
		if (isEmpty()){
			lastLink = newLink;		
		} else {
			firstLink.previous = newLink;
		}	
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	//Insert into last position
	public void insertTail (T value){
		NodeUMUC newLink = new NodeUMUC (value);
		if (isEmpty()){
			firstLink = newLink;		
		} else {
			lastLink.next = newLink;
			newLink.previous = lastLink;
		}
		lastLink = newLink;
	}
	
	//Remove first item in list
	public void removeHead(){
		if (isEmpty()){
			throw new EmptyStackException();
		} else if (firstLink == lastLink){
			firstLink = null;
			lastLink = null;
		} else {
			firstLink = firstLink.next;
		    }
		}
	
	//Remove last item in list
	public void removeTail(){
		if (isEmpty()){
			throw new EmptyStackException();
		} else if (firstLink == lastLink){
			firstLink = null;
			lastLink = null;
		} else {
			lastLink = null;
		    }
		}
	
	//Removes element at defined position
	public void removeElementAt (int x) {
		if (isEmpty() || x > count()){
			throw new EmptyStackException();
		} else if (x == 0) {
		    firstLink = firstLink.next;
		} else {
		    NodeUMUC current = firstLink;
		    for (int i = 0; i <= x - 1; i++) {
		           current = current.next;
		           firstLink = current;
		           }
		    }
	}
	
	//Peeks head
	public void peekHead () {
		if (isEmpty()){
			throw new EmptyStackException();
		} else {
		System.out.println(firstLink + " is at the front of the list!");
		}
	}
	
	//Peeks tail
	public void peekTail () {
		if (isEmpty()){
			throw new EmptyStackException();
		} else if (lastLink == null){
			System.out.println ("No value exists here!");
		} else {
			System.out.println(lastLink + " is at the end of the list!");
		}
	}	
	
	//Peeks element at defined position
	public void peekElementAt (int x) {
		if (isEmpty() || x > count()){
			throw new EmptyStackException();
		} else if (x == 0) {
		    System.out.println(firstLink);
		} else {
		    NodeUMUC current = firstLink;
		    int i = 0;
		    while (i < x){
		    	i++;
		    	current = current.next;
		    	if (i == x){
		    		System.out.println(current);;
		    	}
		      }
		 }
	}
	
	
	//Checks if node is empty
	public boolean isEmpty(){
		return(firstLink == null);
		    }
	
	//Displays all nodes
	public void display(){
		if (isEmpty()){
			System.out.println ("No value exists here!");
		}
		NodeUMUC link = firstLink;
		while(link != null){
			link.display();
		    System.out.println("Next Node = " + link.next);
		    link = link.next;
		    System.out.println();
			}
		}

	//Counts all nodes
	public int count() {
    int count = 0;
    for (NodeUMUC n = firstLink; n != null; n = n.next) {
        count++;
    }
    return count;
	}
}

class NodeUMUC<T> {

	T value;
	int element;
	NodeUMUC next;
	NodeUMUC previous;
	
	public NodeUMUC(T value){
		this.value = value;
	}
	
	public void display(){
		System.out.println("Value = " + toString());
	}
	
	public String toString(){
		return value.toString();
	}
}

	
	
