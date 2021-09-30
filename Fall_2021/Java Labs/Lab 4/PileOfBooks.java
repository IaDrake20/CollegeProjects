import java.util.Arrays;

public class PileOfBooks {
    
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

        //if array is full, double the capacity then add to array
        if(isArrayFull()){

            System.out.println("doubling capacity");
            doubleCapacity();
        }

        //System.out.println("ADD:: number of books ..."+ numberOfBooks);
        pile[numberOfBooks] = newBook;
        numberOfBooks ++;
    }

    public Book getTopBook() {
        
        return pile[numberOfBooks];
    }

    public Book removeTopBook() {

        //take latest entry, set it equal to null and reduce numberOfBooks by 1
        Book returnMe = pile[numberOfBooks];
        numberOfBooks --;

        return returnMe;
    }

    public void clear(){

        for(int i = 0; i < numberOfBooks; i++){
            pile[i] = null;
        }

    }

    private boolean isArrayFull(){

        if(numberOfBooks == pile.length){

            return true;
        }

        return false;
    }

    private void doubleCapacity() {

        Book[] temp;
        
        temp = Arrays.copyOf(pile, numberOfBooks * 2);
        pile = temp;
    }

    public Book[] toArray(){

        Book[] result = new Book[numberOfBooks];
        result = Arrays.copyOf(pile, numberOfBooks);
        System.out.println(result.toString());
        return result;
    }

    public boolean contains(Book b){

        for(int i = 0; i < numberOfBooks; i++){

            if(pile[i].equals(b)){
                
                return true;
            }
        }

        return false;
    }

    public int getFrequencyOf(Book b){
        
        int count = 0;

        for(int i = 0; i < numberOfBooks; i++){

            if(pile[i].equals(b)){

                count++;
            }
        }
        
        return count;
    }
}
