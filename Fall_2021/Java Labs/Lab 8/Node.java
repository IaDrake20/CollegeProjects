public class Node<T>  {
	// Create two private instance variable for data and next

	T data;
	T next;

  
  
	// Constructors
	public Node(T dataPortion)
	{
		data = dataPortion;

	}
  
	public Node(T dataPortion, Node<T> linkPortion)
	{
		data = getData();
		next = getNext();

	} 

	// Write two get methods and two set methods
	
	public void setData(T d){
		data = d;
	}

	public void setNext(T n){
		next = n;
	}

	public T getData(){
		return data;
	}

	public T getNext(){
		return next;
	}
	
	
	
	
	// Write toString method to return the data in the node
	public String toString(){
		return "data: "+data+ " Next: "+next;
	}
	
	
		
}