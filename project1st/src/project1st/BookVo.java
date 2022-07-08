package project1st;

public class BookVo {
	private int book_id;
	private int amount;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private String publication_date;
	private String purchase_date;
	
	public BookVo() {
		
	}
	
	
	
	public BookVo( String title, String author, String publisher,String genre,
			String publication_date) {
		
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.publication_date = publication_date;
		
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	
	
	
	
	
}
