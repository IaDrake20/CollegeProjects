public final class LinkedQueue<T> implements QueueInterface<T>  {
	
	private Node<T> frontNode;
	private Node<T> backNode; 
	   
	public LinkedQueue()
	{




	}
		
	public void enqueue(T newItem)
	{
		// Create node with data newItem which does not point to anything
		


		// Deal with two different cases	
		if (isEmpty())
		
	
	
		else
		  
		
	}

	public T getFront()
	{
		// Must throw EmptyQueueException if the queue is empty



	} 
	   
	public T dequeue()
	{
		T front = getFront();
		frontNode.setData(null);
		
		// set frontNode to the second node



		// Deal with two different cases
		if (frontNode == null)


		else


	}
			
	public boolean isEmpty()
	{
	

	} 
	   
	public void clear()
	{
	

	}
	
	
	
	public int numNodes() {


	}		
		
   
	// Return the queue as a String from front to backNode
	// Print the data part of each node in the queue
	// Call to the toString method in Node when necessary
 	public String toString() {
        
	}

}
