public class TestQueue  {
	public static void main(String[] args) {
		
		LinkedQueue<String> myQueue = new LinkedQueue<>();
		myQueue.enqueue("Joe");
		myQueue.enqueue("Jim");
		myQueue.enqueue("Jane");
		myQueue.enqueue("James");
		
		System.out.println("Number of nodes in the queue is " + myQueue.numNodes());
		System.out.println("Queue is " + myQueue.toString());
		
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.getFront());
		myQueue.enqueue("Jerry");
		
		System.out.println("Number of nodes in the queue is " + myQueue.numNodes());
		System.out.println("Queue is " + myQueue.toString());

		System.out.println("Queue is empty.." + myQueue.isEmpty());
		System.out.println(myQueue.dequeue());
		myQueue.clear();
		System.out.println("Queue is empty.." + myQueue.isEmpty());
		try{
			myQueue.dequeue();
		}
		catch(EmptyQueueException e){
			
		}
		
		myQueue.enqueue("Sam");
		myQueue.enqueue("Sandy");
		myQueue.enqueue("Simone");
		System.out.println("Number of nodes in the queue is " + myQueue.numNodes());
		System.out.println("Queue is " + myQueue.toString());


		
	}
}
		
		