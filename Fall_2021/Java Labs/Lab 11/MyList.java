// MyList class is exactly the same as the LList class from the book
// You must add 8 extra methods and a main
// Do not change any of the existing code

import java.util.Random;

public class MyList<T> implements ListInterface<T>
{
	private Node firstNode;
	private int  numberOfEntries;
	
	public MyList()
	{
		initializeDataFields();
	}
	
	public void clear()
	{
		initializeDataFields();
	}
	
	public void add(T newEntry)	
	{
		Node newNode = new Node(newEntry);
		
		if (isEmpty())
			firstNode = newNode;
		else
		{
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		} 
		
		numberOfEntries++;
	}

	public void add(int givenPosition, T newEntry)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
		{
			Node newNode = new Node(newEntry);
			if (givenPosition == 1)	
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	}

	public T remove(int givenPosition)
	{
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			if (givenPosition == 1)	
			{
				result = firstNode.getData();
				firstNode = firstNode.getNextNode(); 
			}
			else
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
		  }
			numberOfEntries--;	
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}

	public T replace(int givenPosition, T newEntry)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	public T getEntry(int givenPosition)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}
	
	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		
		return result;
	} 
															
	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		
		return found;
	}

	public int getLength()
	{
		return numberOfEntries;
	}

	public boolean isEmpty()
	{
		boolean result;
		
		if (numberOfEntries == 0)
		{
			result = true;
		}
		else
		{
			result = false;
		} 
		
		return result;
	}
	
	// Put new methods here
	// When writing the methods you do not need to access the list directly.
	// Instead use the numberOfEntries instance variables 
	// and the methods that already exist in the class

	/**
	 * swap
	 * @param pos1
	 * @param pos2 
	 * take pos1, save it, then replace it with pos2. Then replace pos2 with pos1
	 */
	public void swap(int pos1, int pos2) {

		//save pos 1
		T temp1 = this.getNodeAt(pos1).getData();

		//save pos 2
		T temp2 = this.getNodeAt(pos2).getData();

		//set pos1's data to pos2
		this.getNodeAt(pos1).setData(temp2);

		//set pos2's data to pos1
		this.getNodeAt(pos2).setData(temp1);
	}

	public void reverse(){

		//call swap for 1st pos and last pos, then 2nd pos and lastPos-1, etc
		for(int i = 1; i <= (0.5 * this.numberOfEntries);i++) {
				
			this.swap(i, this.numberOfEntries-(i-1));
		}
			
	}

	public int findEntryFromFront(T entry){

		int foundIndex = 0;

		if(this.contains(entry)){

			//search for firstIndex
			for(int i = 1; i <= this.numberOfEntries; i++ ){

				if(this.getEntry(i) == entry){
					foundIndex = i;
				}
			}
		}

		return foundIndex;
	}

	public int findEntryFromBack(T entry){
		int foundIndex = 0;

		if(this.contains(entry)){

			//search for firstIndex
			for(int i = this.numberOfEntries; i >= 1; i-- ){

				if(this.getEntry(i) == entry){
					foundIndex = i;
				}
			}
		}

		return foundIndex;
	}

	public int containsAmountOf(T entry){

		int count = 0;
		
		for(int i = 1; i <= this.numberOfEntries; i++){
			if( this.getNodeAt(i) == entry){
				++count;
			}
		}

		return count;
	}

	public T removeAllOfSpecificEntry(T entry){
 
		//doesn't matter what is assigned to this
		T temp = null;
		
		for(int i = 1; i <= this.numberOfEntries; i++){
			if(this.getEntry(i) == entry){

				temp = this.getNodeAt(i).data;
				this.remove(i);

				//System.out.println("I removed a "+entry);
			}
		}

		if(this.getNodeAt(this.numberOfEntries).getData() == entry){

			this.remove(this.numberOfEntries);
		}

		return temp;
	}

	public void shuffle() {

		int randomNumber;
		Random random = new Random();

		for(int i = 1; i <= this.numberOfEntries; i++){
			randomNumber = random.nextInt(this.numberOfEntries);
			swap(i, randomNumber);
		}
		 

	}

	public String toString(){

		String returnMe = "";

		//System.out.println(numberOfEntries);

		for(int i = 1; i <= this.numberOfEntries; i++){
			//System.out.println("in for loop");
			returnMe += "\nNode "+i+ " contains... "+this.getNodeAt(i).data;
			
			//this line will print the address for next, not required by instructions
			//returnMe += " next: "+this.getNodeAt(i).next+" \n";
		}

		//System.out.println("\ntest print\n"+this.getNodeAt(3).data);

		return returnMe;
	}
	
	private void initializeDataFields()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	private Node getNodeAt(int givenPosition)
	{
		Node currentNode = firstNode;
		
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		
		return currentNode;
	}
	
	// Inner class 
	private class Node
	{
		private T	 data;
		private Node next;
		
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		}
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		}
		
		private T getData()
		{
			return data;
		}
		
		private void setData(T newData)
		{
			data = newData;
		}
		
		private Node getNextNode()
		{
			return next;
		}
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} 
	}  // end of inner class


	public static void main(String[] args) {
		// Complete the main as specified in the assignment
		// You will need to call your new methods

	
		//create a MyList object
		MyList <String> list1 = new MyList<>();  
	
		//Add strings to it
		list1.add("January");
		list1.add("May");
		list1.add("August");
		list1.add("January");
		list1.add("November");
		list1.add("July");
		list1.add("January");
		list1.add("December");

		list1.swap(2, 4);

		list1.reverse();

		System.out.println(list1.findEntryFromFront("January"));

		System.out.println(list1.findEntryFromBack("January"));

		System.out.println("January appears "+list1.containsAmountOf("January")+" times.");

		System.out.println(list1.removeAllOfSpecificEntry("January"));

		list1.shuffle();

		System.out.println(list1.toString());
	}	
		
}
	
	
	
	
	
	
	
	
	
	
		