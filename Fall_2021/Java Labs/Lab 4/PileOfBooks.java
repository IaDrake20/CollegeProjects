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

            doubleCapacity();
        }

        numberOfBooks ++;
        pile[numberOfBooks] = newBook;
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

        if(numberOfBooks == DEFAUlT_CAPACITY){

            return true;
        }

        return false;
    }

    private void doubleCapacity() {

        Book[] temp = new Book[numberOfBooks * 2];
        
        for(int i = 0; i < numberOfBooks; i++){

            temp[i] = pile[i];
        }

        for(int i = 0; (numberOfBooks + i) < temp.length; i++ ){

            temp[i] = null;
        }

        pile = temp;
    }

    public Book[] toArray(){

        Book[] result = new Book[numberOfBooks];
        result = Arrays.copyOf(pile, numberOfBooks);
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
