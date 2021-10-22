/****************
* Ian Drake
* 9/9/2021
* Section 4010
* This class will hold 50 rectangles and the class will be used to represent them in a graphics program or something
******************/

public class RectangleGroup{

    private int numRectangles;
    private Rectangle[] theRectangles;

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
        if(numRectangles < 50){ 
        theRectangles[numRectangles] = r;
        numRectangles++;
        }
    }

    public boolean isEmpty() {
        
        if(numRectangles == 0){
            return true;
        }
        return false;
    }

    public double largestArea() {

        double highestArea = theRectangles[0].calcArea;

        for(int i = 0; i < numRectangles; i++){

            if (theRectangles[i].calcArea() > highestArea){}
				highestArea = theRectangles[i].calcArea();
            }
        }

         return highestArea;
    }

    public double largestPerimeter() {
        
        double highestPerimeter = theRectangles[0].calcPerimeter();

        for(int i = 0; i < numRectangles; i++){

           if(theRectangles[i].calcPerimeter > highestPerimeter){
               highestPerimeter = theRectangles[i].calcPerimeter();
           }
        }
         return highestPerimeter;
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