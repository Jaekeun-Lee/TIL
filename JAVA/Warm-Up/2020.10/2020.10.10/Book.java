 
public class Book {

	/// Field
	private String title;
	private String kind;
	private int rentalPrice;

	/// Constructor
	public Book() {
	}

	public Book(String title, String kind, int rentalPrice) {
		super();
		this.title = title;
		this.kind = kind;
		this.rentalPrice = rentalPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(int rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [title=");
		builder.append(title);
		builder.append(", kind=");
		builder.append(kind);
		builder.append(", rentalPrice=");
		builder.append(rentalPrice);
		builder.append("]");
		return builder.toString();
	}

}
