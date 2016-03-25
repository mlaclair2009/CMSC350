package finalProject;
//UMUC CMSC 350 
//Class Graph - Defines an undirected graph
//Adapted by Ioan from:
//Liang - Introduction to Java Programming, 9th Edition (Code Examples of Chapter 30 Graphs and Applications)
//Source code of the examples available at: 
//http://www.cs.armstrong.edu/liang/intro9e/examplesource.html

import java.util.*;

public class Graph<V> {
protected List<V> vertices = new ArrayList<V>(); // Store vertices
protected List<List<Integer>> neighbors = new ArrayList<List<Integer>>(); // Adjacency lists

/** Construct an empty graph*/
protected Graph() {
}

/** Return the number of vertices in the graph */
public int getSize() {
 return vertices.size();
}

/** Return the vertices in the graph */
public List<V> getVertices(int index) {
 return vertices;
}

/** Return the object for the specified vertex */
public V getVertex(int index) {
 return vertices.get(index);
}

/** Return the index for the specified vertex object */
public int getIndex(V v) {
 return vertices.indexOf(v);
}

/** Return the neighbors of the specified vertex */
public List<Integer> getNeighbors(int index) {
 return neighbors.get(index);
}

/** Return the degree for a specified vertex */
public int getDegree(int v) {
 return neighbors.get(v).size();
}

/** Print the edges */
public void printEdges() {
 for (int u = 0; u < neighbors.size(); u++) {
   System.out.print(getVertex(u) + " (" + u + "): ");
   for (int j = 0; j < neighbors.get(u).size(); j++) {
     System.out.print("(" + u + ", " +
       neighbors.get(u).get(j) + ") ");
   }
   System.out.println();
 }
}

//Get edges for specific index
public Integer getEdges(int index) {
	Integer list = null;
	   for (int j = 0; j < neighbors.get(index).size(); j++) {
	       list = neighbors.get(index).get(j);
	 }
	return list;
}

//Count all edges
public float countEdges() {
	int count = 0;
	   for (int u = 0; u < neighbors.size(); u++) {
		   for (int j = 0; j < neighbors.get(u).size(); j++) {
			   count++;
		   }
	 }
	return count/2;
}

/** Clear graph */
public void clear() {
 vertices.clear();
 neighbors.clear();
}

/** Add a vertex to the graph */  
public void addVertex(V vertex) {
 vertices.add(vertex);
 neighbors.add(new ArrayList<Integer>());
}

/** Add an edge to the graph */  
public void addEdge(int u, int v) {
 neighbors.get(u).add(v);
 neighbors.get(v).add(u);
}


/** Edge inner class inside the Graph class */
public static class Edge {
 public int u; // Starting vertex of the edge
 public int v; // Ending vertex of the edge

 /** Construct an edge for (u, v) */
 public Edge(int u, int v) {
   this.u = u;
   this.v = v;
 }
}
}


