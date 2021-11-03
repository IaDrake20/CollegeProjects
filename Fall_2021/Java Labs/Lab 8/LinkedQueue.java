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
			
		}
		
	
	
		else{
			
		}
		  
		

	}

	public T getFront()
	{
		// Must throw EmptyQueueException if the queue is empty
		EmptyQueueException excep = new EmptyQueueException();
		if(frontNode == null){
			throw excep;
		}
		else{
			return frontNode.getData();
		}

	} 
	   
	public T dequeue()
	{
		T front = getFront();
		frontNode.setData(null);
		
		// set frontNode to the second node
		frontNode = frontNode.getNext();


		// Deal with two different cases
		if (frontNode == null){

			
		}


		else{

		}


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

			//check the .next, if it points to something yay, otherwise leave
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
