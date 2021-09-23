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
}