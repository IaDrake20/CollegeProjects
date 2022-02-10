import org.w3c.dom.Node;

// Complete the methods as explained before
// do not change complete methods (noted below)
// Use the handout from Canvas to help
// Do not change the main

// There are no duplicates in the tree any new item that is added
// is not already in the tree
// For comparisons of T objects DO NOT USE CONDITIONS LIKE
// T1 > T2, T2 <= T1
// Objects of type T MUST BE COMPARED AS FOLLOWS.
// T1.compareTo(T2) < 0 is true when T1 is less than T2
// T1.compareTo(T2) > 0 is true when T1 is greater than T2 
// T1.compareTo(T2) == 0 is true when T1 is equal to T2
// T1.equals(T2) is true when T1 is equal to T2

public class BinarySearchTree<T extends Comparable<? super T>> { 
	
	// Inner class to represent a BinaryNode<T>
	class BinaryNode<T> {
		private T data;
		private BinaryNode<T> left;
		private BinaryNode<T> right;
		
		public BinaryNode(T d) {
			data = d;
			left = null;
			right = null;
		}
	} // End inner class
	
	// Every tree is represented by its root
	private BinaryNode<T> root;

	// Constructor
	public BinarySearchTree() {
		root = null;
	}
	
	// This method is complete
	public boolean recSearch(T searchItem ) {
		return bstRecSearch(root, searchItem);
	}
		
	// Complete the method below
	// The recursive method will return true if searchItem is in the tree 
	// rooted at root. If not found it returns false
	public boolean bstRecSearch(BinaryNode<T> root, T searchItem ) {

		if(root == null){
			return false;
		}

		else if(searchItem == root.data){
			return true;
		}

		else if(searchItem.compareTo(root.data) < 0){
			bstRecSearch(root.left, searchItem);
		}

		else {
			bstRecsearch(root.right, searchItem);
		}
	}

	// This method is complete
	public boolean iterSearch(T searchItem ) {
		if (root == null)
			return false;
		else
			return bstIterSearch(root, searchItem);
	}
	
	// Complete the method below
	// This iterative method will return true if searchItem is in the tree 
	// rooted at root. If not found it returns false
	public boolean bstIterSearch(BinaryNode<T> root, T searchItem)  {

		Node currentNode = root;
		while(current != null){

			if(searchItem == root.data){
				return true;
			}

			else if(searchItem.compareTo(root.data) < 0){
				currentNode = currentNode.getFirstChild();
			}

			else {
				currentNode = currentNode.getLastChild();
			}
		}
		
		//if the method gets this far then searchItem wasn't found
		return false;
	}
	
	// This method is complete
	public void recInsert(T newEntry) {
		if (root == null)
			root = new BinaryNode<T>(newEntry);
		else	
			bstRecInsert(root, newEntry);
	}
	
	// Complete the method below
	// This recursive method will insert newEntry into its correct
	// position in the binary search tree rooted at root
	public void bstRecInsert(BinaryNode<T> root, T newEntry)  {
        
        if(newEntry.compareTo(root.data) < 0){
            
            if(root.left != null){
                bstRecInsert(root.left, newEntry);
            }

            else {
                Node newNode = newEntry;
                root.left = newNode;
            }
        }

        else {
            
            if(root.right != null){
                bstRecInsert(root.right, newEntry);
            }

            else {
                Node newNode = newEntry;
                root.right = newNode;
            }
        }
        
	}
	
	// This method is complete
	public void iterInsert(T newEntry) {
		if (root == null)
			root = new BinaryNode<T>(newEntry);
		else	
			bstIterInsert(root, newEntry);
	}
	
	// Complete the method below
	// This iterative method will insert newEntry into its correct
	// position in the binary search tree rooted at root
	public void	bstIterInsert(BinaryNode<T> root, T newEntry) {

        boolean isPlaced = false;
        Node currentNode = root;

        while(!isPlaced){

            if(newEntry.compareTo(root.data) < 0){

                if(root.left != null){
                    currentNode = currentNode.left;
                }

                else {
                    Node newNode = newEntry;
                    root.left = newNode;
                    isPlaced = true;
                }
            }
            else {
                if(root.right != null){
                    currentNode = currentNode.right;
                }

                else {
                    Node newNode = newEntry;
                    root.right = newNode;
                    isPlaced = true;
                }
            }
        }
	}
	
	// This method is complete
	public boolean bstDelete(T anEntry) {
		if (root == null) 
			return false;
		else {
			return (bstRecDelete(root, anEntry) != null);
		}
	}
	
	// Complete the method below
	// This recursive method will delete the node whose data matches anEntry
	// The method returns the nodes if it is inserted otherwise it returns nulls
	public BinaryNode<T> bstRecDelete(BinaryNode<T> root, T anEntry) {
		// Declare any variables here
		

		
		if (root == null)
			return null;
		
		else if (anEntry.equals(root.data)) {
			// Handle 4 cases
			// 1. root has no children
            if(root.left == null && root.right == null){

            }

			// 2. root has a left child but no right child
            else if(root.left != null){

            }
			// 3. root has a right child but no left child
            else if(root.right != null){

            }
			// 4. rott has a left child and a right child
			else if(root.left != null && root.right != null){

            }	
		else if (anEntry.compareTo(root.data) < 0) {
			bstRecDelete(root.left, T anEntry);
	
		}
		else  {
            bstRecDelete(root.right, T anEntry);
		}
		return root;
	}
		
	// This method is complete
	public T minVal() {
		return minVal(root);
	}

	// Complete the method below
	// Returns the smallest value in the tree rooted at root
	public T minVal(BinaryNode<T> root) {
        T result = root.data;
        if(root.left.compareTo(root.right) < 0){
            minVal(root.left);
        }

        else if(root.right.compareTo(root.left) < 0){
            minVal(root.right);
        }
        return result;
	}
	
	// This method is complete
	public T maxVal() {
		return maxVal(root);
	}
	
	// Complete the method below
	// Returns the largest value in the tree rooted at root
	public T maxVal(BinaryNode<T> root) {

        while(root.data.compareTo(root.right.data) < 0){
            root = root.right;
        }
        return root;
	}
	
	// This method is complete
	public void postOrderTraversal() {
		System.out.print("Post Order Traversal: ");
		postOrderTraversal(root);
		System.out.println();
	}
	
	// Complete this method
	// Carries out a postorder traversal
	// Print each node as it is visited
	public void postOrderTraversal(BinaryNode<T> root) {

        if(root.left == null){
            return root;
        }

        else if(root.right == null){
            return root.right;
        }
        
        if(root.left != null){
            postOrderTraversal(root.left);
        }

        else if(root.right != null){
            postOrderTraversal(root.right);
        }

	}

	// This method is complete
	public void inOrderTraversal() {
		System.out.print("In Order Traversal: ");
		inOrderTraversal(root);
		System.out.println();
	}
	

	// Complete this method
	// Carries out an inorder traversal
	// Print each node as it is visited
	public void inOrderTraversal(BinaryNode<T> root) {





	}
	
	
	// Do not change the main
	public static void main(String[] args) {
		BinarySearchTree<String> testTree = new BinarySearchTree<String>();

		System.out.println("Recursive Algorithms");

		testTree.recInsert("Jane");
		testTree.recInsert("John");
		testTree.recInsert("Kim");
		testTree.recInsert("Polly");
		testTree.recInsert("Brenda");
		testTree.recInsert("Darla");
		testTree.recInsert("Jay");
		testTree.recInsert("Jasmine");
		testTree.recInsert("Jim");	
		testTree.recInsert("Jock");	
		
		System.out.println("Minimum value in tree is " + testTree.minVal());
		System.out.println("Maximum value in tree is " + testTree.maxVal());
		
		System.out.println("Jat is in the tree? " + testTree.recSearch("Jat"));
		System.out.println("Darla is in the tree? " + testTree.recSearch("Darla"));
		System.out.println("Des is in the tree? " + testTree.recSearch("Des"));
		System.out.println("Polly is in the tree? " + testTree.recSearch("Polly"));

		testTree.inOrderTraversal();	// check answer from lab class
		testTree.postOrderTraversal();	// check answer from lab class
		System.out.println("Brenda was deleted? " + testTree.bstDelete("Brenda"));
		System.out.println("Jay was deleted? " + testTree.bstDelete("Jay"));
		System.out.println("John was deleted? " + testTree.bstDelete("John"));
		System.out.println("Polly was deleted? " + testTree.bstDelete("Polly"));
		System.out.println("Brenda is in the tree? " + testTree.recSearch("Brenda"));
		System.out.println("Jay is in the tree? " + testTree.recSearch("Jay"));
		System.out.println("John is in the tree? " + testTree.recSearch("John"));
		System.out.println("Polly is in the tree? " + testTree.recSearch("Polly"));
		
		testTree.inOrderTraversal();		// check answer from lab class
		testTree.postOrderTraversal();		// check answer from lab class



		System.out.println("\nIterative Algorithms");

		testTree = new BinarySearchTree<String>();

		testTree.iterInsert("Jane");
		testTree.iterInsert("John");
		testTree.iterInsert("Kim");
		testTree.iterInsert("Polly");
		testTree.iterInsert("Brenda");
		testTree.iterInsert("Darla");
		testTree.iterInsert("Jay");
		testTree.iterInsert("Jasmine");
		testTree.iterInsert("Jim");	
		testTree.iterInsert("Jock");	
		
		System.out.println("Minimum value in tree is " + testTree.minVal());
		System.out.println("Maximum value in tree is " + testTree.maxVal());
		
		System.out.println("Jat is in the tree? " + testTree.iterSearch("Jat"));
		System.out.println("Darla is in the tree? " + testTree.iterSearch("Darla"));
		System.out.println("Des is in the tree? " + testTree.iterSearch("Des"));
		System.out.println("Polly is in the tree? " + testTree.iterSearch("Polly"));

		testTree.inOrderTraversal();		// check answer from lab class
		testTree.postOrderTraversal();		// check answer from lab class



	}
}
	
		

		
		