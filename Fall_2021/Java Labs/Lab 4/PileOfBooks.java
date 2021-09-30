/**
 * Ian Drake
 * Section 4010
 * PileOfBooks is a class that represents a pile of books. The class contains methods that
 * consist of getting the size of the class, whether it is empty, getting or removing the top book, clearing 
 * the Book[] pile or checking to see if it is full, and several other methods.
 */
import java.util.Arrays;

public class PileOfBooks {
    
    private Book[] pile;
    private int numberOfBooks = 0;
    private static final int DEFAUlT_CAPACITY = 50;

    public PileOfBooks(){
    }


    public PileOfBooks(int initialCapacity){

        pile = new Book[initialCapacity];

        if(initialCapacity > DEFAUlT_CAPACITY){
            initialCapacity = DEFAUlT_CAPACITY;
            System.out.println("The initial capacy exceeded the default, so the array has been set to the default of size 50");
        }
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

            //System.out.println("doubling capacity");
            doubleCapacity();
        }

        //System.out.println("ADD:: number of books ..."+ numberOfBooks);
        pile[numberOfBooks] = newBook;
        numberOfBooks ++;
    }

    public Book getTopBook() {
        
        return pile[numberOfBooks -1];
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

        Book[] result;
        result = Arrays.copyOf(pile, numberOfBooks);
        //System.out.println(result.toString());
        return result;
    }

    public boolean contains(Book b) {

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
