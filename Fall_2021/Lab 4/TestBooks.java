import java.util.Arrays;

public class TestBooks {
	public static void main(String[] args) {
		PileOfBooks bookStack = new PileOfBooks(3);
		Book b1 = new Book("1984", "George Orwell", 1949);
		Book b2 = new Book("Moby Dick", "Herman Melville", 1851);
		Book b3 = new Book("Catch-22", "Joseph Heller", 1961);
		Book b4 = new Book("Slaughterhouse-Five", "Kurt Vonnegut", 1969);
		Book b5 = new Book("1984", "George Orwell", 1949);
		Book b6 = new Book("To Kill a Mockingbird", "Harper Lee", 1851);
		Book b7 = new Book("1984", "George Orwell", 1949);
		Book b8 = new Book("Catch-22", "Joseph Heller", 1961);
		Book b9 = new Book("The Scarlet Letter", "Nathaniel Hawthorne", 1850);
		Book b10 = new Book("Moby Dick", "Herman Melville", 1851);

		bookStack.add(b1);
		bookStack.add(b2);
		bookStack.add(b3);
		bookStack.add(b4);
		bookStack.removeTopBook();
		bookStack.add(b5);
		bookStack.add(b6);
		bookStack.add(b7);
		bookStack.add(b8);
		bookStack.removeTopBook();
		bookStack.add(b9);
		bookStack.add(b10);
		
		System.out.println("The stack is:");
		System.out.println(Arrays.toString(bookStack.toArray()));
		System.out.println("The top item in the atack is " + bookStack.getTopBook());
		
		Book search1 = new Book("The Scarlet Letter", "Nathaniel Hawthorne", 1850);
		Book search2 = new Book("Pride and Prejudice", "Jane Austen", 1813);
		Book search3 = new Book("Moby Dick", "Herman Melville", 1851);
		
		if (bookStack.contains(search1))
			System.out.println(search1.getTitle() + " is in the stack"); 
		else
			System.out.println(search1.getTitle() + " is not in the stack"); 

		if (bookStack.contains(search2))
			System.out.println(search2.getTitle() + " is in the stack"); 
		else
			System.out.println(search2.getTitle() + " is not in the stack"); 
		
		System.out.println(search3.getTitle() + " has " 
			+ bookStack.getFrequencyOf(search3) + " copies in the stack."); 
			
		bookStack.clear();
		System.out.println("The stack is:");
		System.out.println(Arrays.toString(bookStack.toArray()));
	
		
	}
}

		
		
		