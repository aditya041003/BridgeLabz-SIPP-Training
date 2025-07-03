class Book{
    String title; int publicationYear;
    Book(String title,int year){ this.title=title; this.publicationYear=year;}
    void displayInfo(){ System.out.println("Title:"+title+" Year:"+publicationYear); }
}
class Author extends Book{
    String name,bio;
    Author(String title,int year,String name,String bio){ super(title,year); this.name=name; this.bio=bio;}
    void displayInfo(){ super.displayInfo(); System.out.println("Author:"+name+" Bio:"+bio); }
}
public class LibraryBookAuthor{
    public static void main(String[] args){
        Author a=new Author("1984",1949,"George Orwell","English novelist");
        a.displayInfo();
    }
}