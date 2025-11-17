/*Create package by name com.cg.assign1 

Create a book class with   bookid,bookname,bookprice,author . 

Create Author class with authorname as attribute    

Book has author with attribute author name.        

Create three objects of book class (use constructor and getter setter).              

Count Total number of books and auto increment book id */


package com.cg.assign1;

//Author class

class Author{
	private String authorName;
	
	public Author(String authorName) {
		this.authorName = authorName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}

//Book class

class Book {
	
	private static int bookCounter = 0;  //auto-inc
	
	private int bookId;
	private String bookName;
	private double bookPrice;
	private Author author;
	
	public Book(String bookName,double bookPrice, Author author) {
		this.bookId=++bookCounter; //auto-inc
		this.bookName = bookName;
	    this.bookPrice = bookPrice;
	    this.author = author;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author=author;
		
	}
	
	public void displayBook() {
		System.out.println("Book ID: "+ bookId + ", Book Name: "+bookName + ", Price: "+bookPrice + ",Author: "+ author.getAuthorName());
	}
	
	public static int getTotalBooks() {
		return bookCounter;
	}
	
	
}




public class Assign1Demo {
	
	public static void main(String[] args)
	{
		Author a1 = new Author("Ambedkar");
		Author a2 = new Author("APJ Abdul Kalam");
		Author a3= new Author("Bharatiyar");
		
		Book b1= new Book("Book NO:1", 300.50,a1);
		Book b2 = new Book("Book NO:2", 450.30,a2);
		Book b3 = new Book("Book NO:3",290.50,a3);
		
		b1.displayBook();
		b2.displayBook();
		b3.displayBook();
		
		System.out.println("Total no. of books: "+ Book.getTotalBooks());
		
	}

}
