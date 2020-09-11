
public class Book extends Product {
	private int ISBN;
	private String title;
	private String author;
	public Book(int productID, String description, String maker, int price, int ISBN, String title, String author) {
		super(productID, description, maker, price);
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getISBN() {
		return ISBN;
	}
	public void showInfo() {
		super.showInfo();
		System.out.println("ISBN>>"+ISBN);
		System.out.println("책 제목>>"+title);
		System.out.println("저자>>"+author);
	}
}
