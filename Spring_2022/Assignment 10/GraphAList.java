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
	/**
	 * 
	 * @param v # of vertices
	 * @param e # of edges
	 */

	public GraphAList(int v, int e){
		numVertices = v;	
		numEdges = e;
		
		// Instantiate edgeLists and then add
		// a succession of new LinkedList to edgeLists 
		edgeLists = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> verticeList = new LinkedList<>();

		//System.out.println(numVertices);
		//produce the list
		for(int i = 0; i < numVertices; i++){
			verticeList.add(i);
			edgeLists.add(verticeList);
			//System.out.print(i+" "+".... "+edgeLists.get(i).toString());
		}

		System.out.println("\n");


		//TODO:produce edges inside boolean ll
	}
	public GraphAList(int v, int e, ArrayList<LinkedList<Integer>> l) {

		//edges[v][v] = l[v][v];
		//GraphAList
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
		//linked list contains neightbors

		if(!edgeLists.get(v1).contains(v2) && !edgeLists.get(v2).contains(v1)){
			//System.out.println("The edge is being made between "+v1+" and "+v2);
			edgeLists.get(v1).add(v2);
			edgeLists.get(v2).add(v1);
		} else {
			//System.out.println("The edge already exists between "+v1+" and "+v2);
		}
	}

	// Remove the edge from vertex v1 to vertex v2
	public void removeEdge(int v1, int v2) {
		edgeLists.get(v1).remove(v2);
		edgeLists.get(v2).remove(v1);
	}

	// Return a String containing all the lists
	// Each list begins with vertex name and then lists its neighbors
	public String toString() {

		String result = "";
		ListIterator<LinkedList<Integer>> iter = edgeLists.listIterator();

		/*
		System.out.println("\nPrinting from constructor\n");
		while(iter.hasNext()){
			result.concat(" "+iter.next().toString()+" --> ");
		}
		*/

		System.out.println("\nPrinting from constructor with size "+edgeLists.size()+"");
		for(int i = 0; i < edgeLists.size(); i++){
			result +=(" "+edgeLists.get(i).toString());
		}
		System.out.println("Result is"+result);
		return result;
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
		LinkedList<Integer> originVertex = edgeLists.get(0);

		System.out.println(originVertex.toString());

		//mark origin as visited
		traversalOrder.add(originVertex.getFirst());
		vertexQueue.add(originVertex.getFirst());
		vertexQueue.add(originVertex.get(originVertex.getFirst()+1));

		while(!vertexQueue.isEmpty()){
			LinkedList<Integer> frontVertex = new LinkedList<Integer>(); 
			frontVertex.add(vertexQueue.remove());
			//System.out.println("printing before while in BFS "+edgeLists.get(frontVertex.getFirst()));
			try {
				while(edgeLists.get(frontVertex.getFirst()) != null){//frontvertex has neighbor
					//System.out.println("front vertext in BFS is currently "+frontVertex.toString());
					int neighbor = frontVertex.removeFirst();
					int nextNeighbor = neighbor; //neighbor of frontvertex
					if(!frontVertex.isEmpty() && !marked.get(nextNeighbor)){
						traversalOrder.add(nextNeighbor);
						vertexQueue.add(nextNeighbor);
					}
					System.out.print(traversalOrder.peek() +" --> ");

				}
			} catch(Exception e){
			}
		}
		System.out.println("END BFS\n");
		return traversalOrder;

		//mark origin as visited
		



/*

while (!vertexQueue.isEmpty())  { 
 frontVertex = vertexQueue.dequeue() 
 while (frontVertex has a neighbor)  { 
  nextNeighbor = next neighbor of frontVertex 
  if (nextNeighbor is not visited)  { 
   Mark nextNeighbor as visited  
   traversalOrder.enqueue(nextNeighbor)  
   vertexQueue.enqueue(nextNeighbor) 
  } 
 } 
} 
return traversalOrder
*/





	}

	// Do the Depth First Traversal starting at vertex 0
	// This must be done by following the pseudocode in the book (see handout)
	// You must also print every edge that is traveled over
	// during the traversal (edges in the tree)
	// Return the traversalOrder structure
	public ArrayDeque<Integer> DFS() { //don't need for this application.
		ArrayDeque<Integer> traversalOrder = new ArrayDeque<>();
		Stack<Integer> vertexStack = new Stack<>();
		ArrayList<Boolean> marked = new ArrayList<>(edgeLists.size());
		int originVertex = edgeLists.get(0).getFirst();

		marked.add(edgeLists.get(0).get(0), true);
		traversalOrder.add(originVertex);

		while(!vertexStack.isEmpty()){
			int topVertex = vertexStack.peek();
			if(marked.get(topVertex+1)){//if top vertex has neighbor
				System.out.print(topVertex +" --> ");
				int nextNeighbor = edgeLists.get(originVertex).getFirst();//next unvisited neighbor
				marked.add(nextNeighbor, true);
				traversalOrder.add(nextNeighbor);
				vertexStack.remove(nextNeighbor);
			} else {
				vertexStack.pop();
			}
		}
		System.out.println("END DFS\n");
		return traversalOrder;
	}	
}
	
	
		
	
	
	
	
	