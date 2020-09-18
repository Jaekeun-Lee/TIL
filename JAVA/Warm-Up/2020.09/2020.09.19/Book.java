package bitcamp015;

public class Book {

	/// Field
	private String title = "";
	private int price = 0;

	/// Constructor
	public Book() {

	}

	public Book(String newTitle, int newPrice) {
		this.title = newTitle;
		this.price = newPrice;
	}

	/// Method
	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int newPrice) {
		this.price = newPrice;
	}

}

class BookMgr {

	/// Field
	Book[] bookList = {};

	/// Constructor
	public BookMgr(Book[] newBookList) {
		this.bookList = newBookList;
	}

	/// Method
	public void printBookList() {
		for(Book b:bookList) {
			System.out.println(b.getTitle());
		}
	}

	public void printTotalPrice() {
		int totalPrice = 0;
		
		for(Book b:bookList) {
			totalPrice += b.getPrice();
		}
		
		System.out.println("전체 책 가격의 합 : "+totalPrice);
	}

}