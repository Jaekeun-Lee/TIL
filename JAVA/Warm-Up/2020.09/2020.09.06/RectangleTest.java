import java.util.Scanner;

public class RectangleTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Rectangle r1 = new Rectangle();
		System.out.print("1번 직사각형의 색 : ");
		r1.setColor(sc.next());
		System.out.print("1번 직사각형의 가로 : ");
		r1.setWidth(sc.nextInt());
		System.out.print("1번 직사각형의 세로 : ");
		r1.setLength(sc.nextInt());
		
		Rectangle r2 = new Rectangle();
		System.out.print("2번 직사각형의 색 : ");
		r2.setColor(sc.next());
		System.out.print("2번 직사각형의 가로 : ");
		r2.setWidth(sc.nextInt());
		System.out.print("2번 직사각형의 세로 : ");
		r2.setLength(sc.nextInt());
		
		sc.close();
		System.out.println("\n==============\n");
		System.out.println(r1.getColor()+" 직사각형\n넓이 = "+r1.area()+"\n둘레 = "+r1.perimiter());
		System.out.println("\n==============\n");
		System.out.println(r2.getColor()+" 직사각형\n넓이 = "+r2.area()+"\n둘레 = "+r2.perimiter());
		System.out.println("\n==============\n");
		
		System.out.print("넓이 비교 ==>");
		if(r1.area()>r2.area()) {
			System.out.println(r1.getColor()+" 직사각형의 넓이가 더 넓습니다.");
		}else if(r1.area()<r2.area()){
			System.out.println(r2.getColor()+" 직사각형의 넓이가 더 넓습니다.");
		}else {
			System.out.println("두 직사각형의 넓이는 같습니다.");
		}
		
		System.out.print("둘레 비교 ==>");
		if(r1.perimiter()>r2.perimiter()) {
			System.out.println(r1.getColor()+" 직사각형의 둘레가 더 큽니다.");
		}else if(r1.perimiter()<r2.perimiter()){
			System.out.println(r2.getColor()+" 직사각형의 둘레가 더 큽니다.");
		}else {
			System.out.println("두 직사각형의 둘레는 같습니다.");
		}
	}
}
