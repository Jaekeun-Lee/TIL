
public class ConversationBook extends Book {
	private String language;
	public ConversationBook(int productID, String description, String maker,
			int price, int ISBN, String title, String author, String language) {
		super(productID, description, maker, price, ISBN, title, author);
		this.setLanguage(language);
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}
	public void showInfo() {
		super.showInfo();
		System.out.println("¾ð¾î>>"+language);
	}
}
