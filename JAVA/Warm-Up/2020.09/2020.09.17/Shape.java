 
public abstract class Shape {

	/// Field
	protected double area;
	private String name;

	/// Constructor
	public Shape() {

	}

	public Shape(String name) {

	}

	/// Method
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void calculationArea();

	public void print() {

	}
}

class Circle extends Shape {

	/// Field
	private double radius;

	/// Constructor
	public Circle(String string, int i) {
		this.setName(string);
		this.setRadius(i);
	}

	/// Method
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void calculationArea() {
		this.area = Math.PI * (radius * radius);
	}

	@Override
	public void print() {
		System.out.println("원의 면적은 : " + this.area);
	}
}

class Rectangle2 extends Shape {

	/// Field
	private double width;
	private double height;

	/// Constructor
	public Rectangle2(String string, int i, int j) {
		this.setName(string);
		this.setWidth(i);
		this.setHeight(j);
	}

	/// Method
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void calculationArea() {
		this.area = this.width * this.height;
	}

	@Override
	public void print() {
		System.out.println("직사각형의 면적은 : " + this.area);
	}
}
