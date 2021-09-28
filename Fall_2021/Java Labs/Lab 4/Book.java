public class Book{
    private String title;
    private String author;
    private int year;

    public Book(){
        title = "";
        author = "";
        year = 0;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear(){
        return year;
    }

    public String setTitle(String t){
        title = t;
        return title;
    }

    public String setAuthor(String a){
        author = a;
        return author;
    }

    public int setYear(int y){
        year = y;
        return year;
    }

    /**
     * 
     * @param Book b 
     * @return true or false based on if the attributes are the same
     */
    public boolean equals(Book b){

        if(this.author.equals(b.author) && (this.title.equals(b.title) && (this.year == b.year))){

            return true;
        }

        return false;
    }    

    public String toString(){
        return "Author is "+author+". Title of the book is "+title+". Year the book was written was "+year+".";
    }

}