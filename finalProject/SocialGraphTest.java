package finalProject;

import java.util.Scanner;
import java.io.File;

import org.junit.Test;

public class SocialGraphTest<V> {
		
	@Test
	public void test() {
		
		SocialGraph test = new SocialGraph();
		
		try{
			Scanner x = new Scanner (new File("input.txt"));
			
			while(x.hasNextLine()){
				String name = x.next();
				
				if (!(name.contains("#"))){
				test.addVertex(name);
				} 
				if (name.contains("#")){
					x.close();
					break;
				}
			}
		} catch (Exception e){
			System.out.println("File Not Found" + "\n" + e.getMessage());
		}
		
		test.addEdge(0, 1);
		test.addEdge(0, 2);
		test.addEdge(1, 2);
		test.addEdge(2, 3);
		test.addEdge(2, 4);
		test.addEdge(2, 6);
		test.addEdge(3, 4);
		test.addEdge(3, 5);
		test.addEdge(5, 6);
		test.addEdge(6, 7);
		
		int selection = 0;
		while (selection != 10){
		Scanner input = new Scanner (System.in);
		
		try{
		
		//Display menu
		System.out.println ("1 - normalizedDegreeOfCentrality");
		System.out.println ("2 - numberOfTrianglesIncidentToVertex");
		System.out.println ("3 - listOfTrianglesIncidentToVertex");
		System.out.println ("4 - clusterIndividual");
		System.out.println ("5 - averageClustering");
		System.out.println ("6 - isAcquaintance");
		System.out.println ("7 - addVertex");
		System.out.println ("8 - addEdge");
		System.out.println ("9 - printEdges");
		System.out.println ("10 - exit");
		System.out.println ("Please choose a menu item: ");
		selection = input.nextInt();
		
		//Find degree of centrality
		if (selection == 1){
		try{
			System.out.println("Enter vertex you would like centrality for:");
			String name = input.next();
			test.normalizedDegreeOfCentrality(name);
			} catch (Exception e){
				System.out.println("Incorrect input" + "\n" + e.getMessage());
			}
		}
		
		//Find number of triangles
		else if (selection == 2) {
		try{
			System.out.println("Enter vertex (name) you would like number of triangles for:");
			String name = input.next();
			int tri = test.numberOfTrianglesIncidentToVertex(name);
			System.out.println(tri);
			} catch (Exception e){
				System.out.println("Incorrect input" + "\n" + e.getMessage());
				}
			}
		
		//List triangles 
		else if (selection == 3) {
		try{
			System.out.println("Enter vertex (name) you would like members of triangles for:");
			String name = input.next();
			test.listOfTrianglesIncidentToVertex(name);
			} catch (Exception e){
				System.out.println("Incorrect input" + "\n" + e.getMessage());
				}
			}
		
		//Cluster individual
		else if (selection == 4) {
			try{
			System.out.println("Enter vertex (name) you would like cluster for:");
			String name = input.next();
			long cluster = (long) test.clusterIndividual(name);
			System.out.println(cluster);
			} catch (Exception e){
				System.out.println("Incorrect input" + "\n" + e.getMessage());
				}
			}
		
		//Calculates density of graph
		else if (selection == 5) {
			test.averageClustering();
			}
		
		//Check if a person knows another person
		else if (selection == 6) {
			try{
			System.out.println("Enter first vertex (name):");
			String name1 = input.next();
			System.out.println("Enter second vertex (name):");
			String name2 = input.next();
			test.isAcquaintance(name1, name2);
			if (true){
				System.out.println(name1 + " can be friends with " + name2);
				}
			if (false){
				System.out.println(name1 + " cannot be friends with " + name2);
			}
			} catch (Exception e){
				System.out.println("Incorrect input" + "\n" + e.getMessage());
			}
		}
		
		//Add new vertex
		else if (selection == 7){
			System.out.println("Enter name you would like to enter as new vertex:");
			try{
			String name = input.next();
			test.addVertex(name);
			} catch (Exception e){
				System.out.println("Incorrect input" + "\n" + e.getMessage());
				}
			}
		
		//Add new edge
		else if (selection == 8){
			System.out.println("Enter start vertex index: ");
			int start = input.nextInt();
			try {
				test.getVertex(start);
			} catch (Exception empty){
				System.out.println("Vertex does not exist" + "\n" + empty.getMessage());
				return;
			}
			
			System.out.println("Enter end vertex index: ");
			int end = input.nextInt();
			
			try {
				test.getVertex(end);
			} catch (Exception empty){
				System.out.println("Vertex does not exist" + "\n" + empty.getMessage());
				return;
				}
			test.addEdge(start, end);
		}
		
		//Print all vertex & edges
		else if (selection == 9){
			test.printEdges();
		}
		
		//Exit program
		else if (selection == 10){
			System.out.println("Thank you for using this program!");
			System.exit (0);
		}
		
		else if (selection > 10 || selection < 1){
			System.out.print ("Your selection was invalid. Please start over. ");
			throw new IndexOutOfBoundsException();
		}
	} catch (Exception e){
		System.out.println("\nIncorrect input" + "\n" + e.getMessage());
	}
		
	}
}

}
