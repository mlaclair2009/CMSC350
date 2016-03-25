package finalProject;

import java.util.*;

public class SocialGraph<V> extends Graph {
	
		//Calculates degree of centrality for vertex
		public void normalizedDegreeOfCentrality(String name){
			try{
			int a = ((vertices.size())-1);
			int element = vertices.indexOf(name);
			int degree = getDegree(element);
			System.out.println("The Degree of Centrality is : " + degree + "/" + a);
			} catch (Exception empty){
				System.out.println("Vertex does not exist" + "\n" + empty.getMessage());
			}
		}
		
		//Calculates the number of triangles incident to vertex
		public int numberOfTrianglesIncidentToVertex(String name){
			try{
				int count = 1;
				int counttri = 0;
				int element = vertices.indexOf(name);
				int degree = getDegree(element);
				if (2 <= degree){
					List a = (List) neighbors.get(element);
					for (int i = 0; i < a.size(); i++){
						int n = (int) a.get(i);
						V first = (V) getVertex(n);
						List f = (List) neighbors.get(vertices.indexOf(first));
						if (f.contains(element))
							count++;
						if ((count / 3) == 1){
							counttri++;
						}	
					}
				}
				return counttri;
			}catch (Exception empty){
				System.out.println("Vertex does not exist" + "\n" + empty.getMessage());
			}
			return 0;	
		}
		
		//Provides the list of triangles incident to vertex
		public void listOfTrianglesIncidentToVertex(String name){
			try{
				int count = 1;
				int counttri = 0;
				int element = vertices.indexOf(name);
				int degree = getDegree(element);
				if (2 <= degree){
					List a = (List) neighbors.get(element);
					for (int i = 0; i < a.size(); i++){
						int n = (int) a.get(i);
						V first = (V) getVertex(n);
						List f = (List) neighbors.get(vertices.indexOf(first));
						if (f.contains(element))
								System.out.println(first);
						}	
					}
				if (degree < 2)
					System.out.println("None exist");
			}catch (Exception empty){
				System.out.println("Vertex does not exist" + "\n" + empty.getMessage());
			}	
		}
		
		
		//Calculates the percentage indicating how close its neighbors are to
		//completing a graph
		public float clusterIndividual(String name){
			float edges = (numberOfTrianglesIncidentToVertex(name))*3;
			int element = vertices.indexOf(name);
			float degree = getDegree(element);
			long cluster = (long) ((edges/(degree*(degree-1))/2)*100);
			return cluster;
		}
		
		//Indicates the overall density of the social graph
		public void averageClustering(){
			long sum = 0;
			float n = getSize();
			for (int i = 0; i < n; i++){
				String name = (String) getVertex(i);
				long cluster = (long) clusterIndividual(name);
				sum += cluster;	
				}
			System.out.println("The total average clustering for the graph is " +
				((1/n)*sum));
			}
		
		//Determines if two people can establish social contact through 
		//transitive acquaintance relationships
		public boolean isAcquaintance(String name1, String name2){
			try{
			int a = getIndex(name1);
			int b = getIndex(name2);
			List c = (List) neighbors.get(a);
			if(c.contains(b)){
				return true;
			}

		}catch (Exception empty){
			System.out.println("Vertex does not exist" + "\n" + empty.getMessage());
			}
			return false;
		}
}

	

