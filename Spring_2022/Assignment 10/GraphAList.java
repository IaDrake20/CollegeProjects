import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ArrayDeque;
import java.util.Stack;

public class GraphAList {
	
	// Assume that the vertex names will be 0, 1, 2, 3, ...... (numVertices - 1)
	private int numVertices;
	private int numEdges;
	
	// To store edges use an array of linked lists
	// Each linked list stores the neighbors of that particular vertex
	private ArrayList<LinkedList<Integer>> edgeLists;
	
	// Constructor
	public GraphAList(int v, int e) {
		numVertices = v;	
		numEdges = e;
		
		// Instantiate edgeLists and then add
		// a succession of new LinkedList to edgeLists 
	}
	
	public void setNumVertices(int v) {
		numVertices = v;
	}
	
	public void setNumEdges(int e) {
		numEdges = e;
	}
	
	public int getNumVertices() {
		return numVertices;
	}
	
	public int getNumEdges() {
		return numEdges;
	}
	
	// Add the edge from vertex v1 to vertex v2
	// Check that the edge is not already there before adding
	public void addEdge(int v1, int v2) {




	}

	// Remove the edge from vertex v1 to vertex v2
	public void removeEdge(int v1, int v2) {




	}

	// Return a String containing all the lists
	// Each list begins with vertex name and then lists its neighbors
	public String toString() {







	}

	// Do the Breadth First Traversal starting at vertex 0
	// This must be done by following the pseudocode in the book (see handout)
	// You must also print every edge that is traveled over
	// during the traversal (edges in the tree)
	// Return the traversalOrder structure
	public ArrayDeque<Integer> BFS() {
		// Use the ArrayDeque structures as queues
		// Use the ArrayList to mark vertices as visited
		ArrayDeque<Integer> traversalOrder = new ArrayDeque<>();
		ArrayDeque<Integer> vertexQueue = new ArrayDeque<>();
		ArrayList<Boolean> marked = new ArrayList<>();
		









	}

	// Do the Depth First Traversal starting at vertex 0
	// This must be done by following the pseudocode in the book (see handout)
	// You must also print every edge that is traveled over
	// during the traversal (edges in the tree)
	// Return the traversalOrder structure
	public ArrayDeque<Integer> DFS() { //don't need for this application.
		ArrayDeque<Integer> traversalOrder = new ArrayDeque<>();
		Stack<Integer> vertexStack = new Stack<>();
		ArrayList<Boolean> marked = new ArrayList<>();
				






	}
			
}
	
	
		
	
	
	
	
	