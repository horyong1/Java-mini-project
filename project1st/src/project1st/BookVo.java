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
	private String checkout_date;
	private String return_date;
	private String id;

	public BookVo() {

	}

	public BookVo(String title, String author, String publisher, String genre, String publication_date) {

		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.publication_date = publication_date;

	}
	public BookVo(String id, String title ,String author, String publisher, String checkout_date, String return_date) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.checkout_date = checkout_date;
		this.return_date = return_date;
		
	}

	public String getPublisher() {
		return publisher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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


	public String getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

}
