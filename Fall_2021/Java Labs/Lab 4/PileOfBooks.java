public class Book {
    
    private Book[] pile;
    private int numberOfBooks = 0;
    private static final int DEFAUlT_CAPACITY = 50;

    public PileOfBooks(){

    }


    public PileOfBooks(int initialCapacity){

        pile = new Book[initialCapacity];
    }

    public int getCurrentSize(){
        return numberOfBooks;
    }

    public boolean isEmpty(){

        if(numberOfBooks == 0){
            
            return true;
        }

        return false;
    }

    public void add(Book newBook){

        numberOfBooks ++;
        pile[numberOfBooks] = newBook;

        //if array is full, double the capacity then add to array
        if(numberOfBooks >= pile.length){
            
        }
        

    }



}
