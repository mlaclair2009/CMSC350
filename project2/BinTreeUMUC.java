package project2;

import java.io.File;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.xml.soap.Node;

public class BinTreeUMUC <T> {
	
	NodeBinTree root;
	int count, leafs, right, left = 0;
	
	//Reads file name from user input and creates binary tree using file
	public void BinTreeUMUC(String fileName){
		try{
			Scanner x = new Scanner (new File(fileName));
			
			//While there is information on input file, nodes will be added
			while(x.hasNext()){	
				int key = x.nextInt();
				NodeBinTree nodeToAdd = new NodeBinTree (key);
				count++;
				
				//If there is no root, create one
				if (root == null){
					root = nodeToAdd;
				}
				
				//Traverse the tree to find appropriate node placement
				traverseAndAdd(root, nodeToAdd);
				NodeBinTree traversingNode = root;
				}				
			
			//Close scanner
			x.close();
			
		} catch (Exception e){
			System.out.println("File Not Found" + "\n" + e.getMessage());
		}
	}

	//Traverses loop to find appropriate placement of new nodes
	public void traverseAndAdd (NodeBinTree root, NodeBinTree nodeToAdd){
		//Compare keys for nodes to decide to go left/right
		if (nodeToAdd.key < root.key){
			if (root.leftChild == null){
				root.leftChild = nodeToAdd;
				left++;	
				
			} else {	
			traverseAndAdd(root.leftChild, nodeToAdd);
			}
			
		//Go right to add node
		} else if (nodeToAdd.key > root.key){
			if (root.rightChild == null){
				root.rightChild = nodeToAdd;
				right++;
				
			} else {
				
			traverseAndAdd(root.rightChild, nodeToAdd);
		}
		}
	}
	
	//Traverses nodes and prints in order
	public void traverseInOrder(NodeBinTree node){
		if (node.leftChild != null){
			traverseInOrder(node.leftChild);
			}
			System.out.println(node.key);
			
		if (node.rightChild != null){
			traverseInOrder(node.rightChild);
			}
		}
	
	//Sorts nodes and puts in-order
	public void toInOrderString(){
		if (root != null){
			NodeBinTree nodeToTraverse = root;
			if (nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
				System.out.println(nodeToTraverse.key);	
				
			} else {	
			if (nodeToTraverse.leftChild != null){
				traverseInOrder(nodeToTraverse.leftChild);
				}
			
			if (nodeToTraverse.key > nodeToTraverse.leftChild.key && nodeToTraverse.key < nodeToTraverse.rightChild.key){
				System.out.println(nodeToTraverse.key);
			}
			
			if (nodeToTraverse.rightChild != null){
				traverseInOrder(nodeToTraverse.rightChild);
				}
			}
		} else{		
		throw new EmptyStackException();
		}
	}
	
	//Traverses nodes and prints in preorder
	public void traversePreOrder(NodeBinTree node){
		System.out.println(node.key);
		if (node.leftChild != null){
			traverseInOrder(node.leftChild);
			}
			
		if (node.rightChild != null){
			traverseInOrder(node.rightChild);
			}
		}
	
	//Sorts nodes and puts in preorder
	public void toPreOrderString(){
		if (root != null){
			NodeBinTree nodeToTraverse = root;
			if (nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
				System.out.println(nodeToTraverse.key);	
				
			} else {	
				traversePreOrder(nodeToTraverse);
			}
		} else{		
		throw new EmptyStackException();
		}
	}	
	
	//Traverses nodes and prints in order
	public void traversePostOrder(NodeBinTree node){
		if (node.leftChild != null){
			traversePostOrder(node.leftChild);
			}
			
		if (node.rightChild != null){
			traversePostOrder(node.rightChild);
			}
		System.out.println(node.key);
		}
	
	//Sorts nodes and prints in postorder
	public void toPostOrderString(){
		if (root != null){
			NodeBinTree nodeToTraverse = root;
			if (nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
				System.out.println(nodeToTraverse.key);	
				
			} else {	
				traversePostOrder(nodeToTraverse);
			}
		} else{		
		throw new EmptyStackException();
		}
	}

	//Counts number of leafs on tree
	public void findLeafs(NodeBinTree node){
		if (node == null){
			leafs = 0;
			return;
		}	
		
		if (node.leftChild == null && node.rightChild == null){
			leafs++;
			
		} else {
			if (node.leftChild != null)
				findLeafs(node.leftChild);
			
			if (node.rightChild != null)
				findLeafs(node.rightChild);
		}
	}
	

	//Level order traversal
	public void toLevelOrderString(){
	Queue <NodeBinTree> q = new LinkedList <NodeBinTree> ();
	q.add((NodeBinTree) root);
	NodeBinTree nodeToTraverse = root;
	
	//add children to queue
	while (!q.isEmpty()) {
	if (nodeToTraverse.leftChild != null) 
	q.add((NodeBinTree) nodeToTraverse.leftChild);
	
	if (nodeToTraverse.rightChild != null)
	q.add((NodeBinTree) nodeToTraverse.rightChild);
	
	System.out.println(q.remove().key);
	nodeToTraverse = q.peek();
		}
	}
	
	//Count nodes on specific level
	public void countNodesLevel(){
		NodeBinTree nodeToTraverse = root;
		if (nodeToTraverse == null){
			throw new EmptyStackException();
		}
		
		Queue <NodeBinTree> q = new LinkedList <NodeBinTree> ();
		q.add((NodeBinTree) root);
		int node1 = 0;
		int node2 = 0;
		int totalCount = 0;
		int rowCount = 0;
		int x = 0;
		

		while (nodeToTraverse.leftChild != null) {
				totalCount++;
				nodeToTraverse = nodeToTraverse.leftChild;   
				}
		
		nodeToTraverse = root;
		
		//Create queue
		while (!q.isEmpty()) {
		if (nodeToTraverse.leftChild != null) 
		q.add((NodeBinTree) nodeToTraverse.leftChild);
		
		if (nodeToTraverse.rightChild != null)
		q.add((NodeBinTree) nodeToTraverse.rightChild);
		
		nodeToTraverse = ((Iterator<NodeBinTree>) q).next();
		}
		
		System.out.println("Enter level you would like to view:");
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		
		//Incorrect input checking
		if (x < totalCount || x > totalCount) {
			throw new IndexOutOfBoundsException();
		}
		
			nodeToTraverse = root;
			
			//for (int i = 0, i < x, i++) {
				//node1 = nodeToTraverse.leftChild.key;
				//nodeToTraverse = nodeToTraverse.leftChild;
			//}
			
			while (q.peek().key != node1){
				q.remove();
				node2 = nodeToTraverse.leftChild.key;
				}
			
			while (q.peek().key != node2){
				rowCount++;
				q.remove();
				}
			System.out.println ("The count of row" + x + " is " + rowCount);
			}
	
	
	//Prints out root of tree
	public void getRoot(){
		System.out.println("Root is: " + root.key);
	}
	
	//Prints number of nodes on tree
	public void countNodes(){
		System.out.println("Total nodes: " + count);
	}
	
	//Prints number of leafs on tree
	public void countLeafs(){
		findLeafs(root);
		System.out.println("Total leafs: " + leafs);
	}
	
	//Prints number of nodes on left side of tree
	public void countLeft(){
		System.out.println("Total left nodes: " + left);
	}
	
	//Prints number of nodes on right side of tree
	public void countRight(){
		System.out.println("Total right nodes: " + right);
	}
}

class NodeBinTree <T> {
	
		int key;
		NodeBinTree leftChild;
		NodeBinTree rightChild;
		
		public NodeBinTree (int key){
			this.key = key;
		}
	}

		


