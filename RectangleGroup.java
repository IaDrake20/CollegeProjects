/****************
* Ian Drake
* 9/9/2021
* Section 4010
* This class will hold 50 rectangles and the class will be used to represent them in a graphics program or something
******************/

public class RectangleGroup{

    private int numRectangles;
    Rectangle[] theRectangles;

    public RectangleGroup() {

        numRectangles = 0;
        theRectangles = new Rectangle[50];
        
    }

    public int getNumRectangles() {
        return numRectangles;
    }

    public Rectangle getRectangle(int i){
        
        return theRectangles[i];
    }

    public void setNumRectangles(int n){

        numRectangles = n;
    }

    public void addRectangle(Rectangle r){
        
        theRectangles[numRectangles] = r;
        numRectangles++;
    }

    public boolean isEmpty() {
        
        if(numRectangles == 0){
            return true;
        }
        return false;
    }

    public double largestArea() {

        double area = 0;
        double area2 = 0;

        for(int i = 0; i < numRectangles; i++){

            area = theRectangles[i].calcArea();

            if( i > 0){
                area2 = theRectangles[i - 1].calcArea();
            }

            else if(area > area2 && i > numRectangles){
                return area;
            }
            
        }

         return area2;
    }

    public double largestPerimeter() {
        
        double perim = 0;
        double perim2 = 0;

        for(int i = 0; i < numRectangles; i++){

            perim = theRectangles[i].calcPerimeter();

            if( i > 0){
                perim2 = theRectangles[i - 1].calcPerimeter();
            }

            if(perim > perim2 && i > numRectangles){
                return perim;
            }
        }
         return perim2;
    }

    public static void printSquares(RectangleGroup rg){ //RectangleGroup
        
        //Rectangle rect = rg.getRectangle

        for(int i = 0; i < rg.getNumRectangles(); i++){

            if( rg.getRectangle(i).isSquare()){
                //System.out.println("I AM A SQUARE");
                System.out.println(rg.getRectangle(i)+" \n");
            }           
        }
    }

    public String toString() {

        String returnMe = "";

        for( int i = 0; i <= numRectangles-1; i++){
            returnMe += theRectangles[i]+" \n";
        }
        return returnMe;
    }
}