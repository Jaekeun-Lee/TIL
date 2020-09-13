public class Rectangle {

	/// Field
	int width; // 가로
	int length; // 세로
	String color; // 색

	
	
	/// Method
	// getter,setter method
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// 넓이 계산
	public int area() {

		int area = width*length;
		
		return area;
	}

	

	// 둘레 계산
	public int perimiter() {

		int perimiter = 2*(width+length);

		return perimiter;
	}

}
