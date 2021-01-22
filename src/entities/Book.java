package entities;

public class Book {
	private int id;
	protected String title;
	private String author;
	private String publisher;
	private String genre;
	private int borrowed;
	private int reserved;
	
	public Object[] toObject() {
		Object[] obj = {title,author,publisher,genre,borrowed,reserved};
		return obj;
	}
	
	public Book() {
		
	}
	
	public Book(Book b) {
		this.id = b.id;
		this.title = b.title;
		this.author = b.author;
		this.publisher = b.publisher;
		this.genre = b.genre;
		this.borrowed = b.borrowed;
		this.reserved = b.reserved;
	}
	
	public Book(int id,String title,String author,String publisher,String genre,int borrowed,int reserved) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.borrowed = borrowed;
		this.reserved = reserved;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return this.author;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisher() {
		return this.publisher;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGenre() {
		return this.genre;
	}
	
	public void setBorrowed(int borrowed) {
		this.borrowed = borrowed;
	}
	public int getBorrowed() {
		return this.borrowed;
	}
	
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public int getReserved() {
		return this.reserved;
	}
}
