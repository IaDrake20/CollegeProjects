public final class LinkedQueue<T> implements QueueInterface<T>  {
	
	private Node<T> frontNode;
	private Node<T> backNode; 
	   
	public LinkedQueue()
	{
			frontNode = null;
			backNode = null;

	}


	//node1 --> node2
		
	public void enqueue(T newItem)
	{
		// Create node with data newItem which does not point to anything
		Node <T> newNode = new Node(newItem, null);


		// Deal with two different cases	
		if (isEmpty()){

			//since 1 node exists, both front and back point to this node
			frontNode = newNode;
			backNode = newNode;
		}
		
	
	
		else{

			//add newNode to the back
			backNode.setNext(newNode);

			//now that something is pointing to newNode, make newNode the backNode
			backNode = newNode;
		}
		  
		

	}

	public T getFront()
	{
		// Must throw EmptyQueueException if the queue is empty
		EmptyQueueException excep = new EmptyQueueException();
		if(frontNode == null){
			throw excep;
		}
		return frontNode.getData();
	} 
	
	/**
	 * if frontNode is null return null and do nothing
	 */
	public T dequeue()
	{
		//an exception will be thrown if getFront is empty
		T front = getFront();
		frontNode.setData(null);
		
		// set frontNode to the second node
		frontNode = frontNode.getNext();

		// Deal with two different cases
		if (frontNode == null){

			backNode = null;
			return front;
		}

		else{


			
		}

		return front;


	}
			
	public boolean isEmpty()
	{
	//check frontNode and BackNode
		boolean v = false;
		if(frontNode == null){
			v = true;
		}	

	return v;

	} 
	   
	public void clear()
	{
		frontNode = null;
		backNode = null;
	}
	
	
	
	public int numNodes() {
		///OPtion A:
		
		boolean endOfList = false;
		Node <T> currentNode;
		int counter = 0;

		currentNode = frontNode.getNext();

		while(!endOfList){

			//check the .next, if it points to something increment count, otherwise leave
			if(currentNode.getData() != null){

				counter++;
				currentNode = currentNode.getNext();
			}

			else {
				System.out.println("CurrNode is null");
				endOfList = true;
			}
			
		}

		return counter;

	}		
		
   
	// Return the queue as a String from front to backNode
	// Print the data part of each node in the queue
	// Call to the toString method in Node when necessary
 	public String toString() {
        return "I'm supposed to be a node's data";
	}

}
