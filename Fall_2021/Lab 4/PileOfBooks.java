public class Book {
    
    private Book[] pile;
    private int numberOfBooks = 0;
    private static final int DEFAUlT_CAPACITY = 50;

    public PileOfBooks(){

    }

    //I don't think the assignment of numberOfBooks is correct
    public PileOfBooks(int initialCapacity){

        numberOfBooks = initialCapacity;
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

        //if array is full, double the capacity then add to array
    }



}
