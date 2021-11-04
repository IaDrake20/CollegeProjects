import javax.swing.text.rtf.RTFEditorKit;

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
		T front;
		try {
		//an exception will be thrown if getFront is empty
			front = getFront();
		}

		catch( EmptyQueueException e){

			System.out.println("No node present");
			return null;
		}

		frontNode.setData(null);
		
		// set frontNode to the second node
		frontNode = frontNode.getNext();

		// Deal with two different cases
		if (frontNode == null){
			backNode = null;
		}

		else{
			//this else doesn't need to exist as the case it would cover
			//is accounted for above
		}

		return front;


	}
			
	public boolean isEmpty()
	{
	//check frontNode
		if(frontNode == null){
			return true;
		}	

		return false;

	} 
	   
	public void clear()
	{
		frontNode = null;
		backNode = null;
	}
	
	
	
	public int numNodes() {
		///OPtion A:
		
		boolean endOfList = false;
		Node <T> currentNode = frontNode;
		int counter = 0;

		//currentNode = frontNode;

		//check 
		if(isEmpty()){
			return 0;
		}

		while(!endOfList){

			counter++;
			currentNode = currentNode.getNext();
			

			if(currentNode == null) {
				//System.out.println("CurrNode is null");
				endOfList = true;
			}
			
		}

		return counter;

	}		
		
   
	// Return the queue as a String from front to backNode
	// Print the data part of each node in the queue
	// Call to the toString method in Node when necessary
 	public String toString() {
        
		boolean endOfList = false;
		Node <T> currentNode;
		currentNode = frontNode;

		String nodeData = "";

		if(isEmpty()){
			return nodeData;
		}

		while(!endOfList){

			nodeData += " "+currentNode.toString();
			currentNode = currentNode.getNext();
			

			if(currentNode == null) {
				endOfList = true;
			}
			
		}
		return nodeData;
	}

}
