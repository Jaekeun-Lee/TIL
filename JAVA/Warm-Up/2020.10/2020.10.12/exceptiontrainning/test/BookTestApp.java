package iopractice.exceptiontrainning.test;

import java.util.Vector;

import iopractice.exceptiontrainning.Book;
import iopractice.exceptiontrainning.exceptionf.DataFormatException;

public class BookTestApp {

	private static Book makeBook(String bookData) throws DataFormatException {

		// title,kind,rentalPrice 무조건 3개의 인자가 들어와야함.
		String[] param = bookData.split(":");

		if (param.length == 3) {

			String title = param[0];
			String kind = param[1];
			int rentalPrice = Integer.parseInt(param[2]);

			return new Book(title, kind, rentalPrice);

		} else {
			throw new DataFormatException(param[0] + " 책은 변환할 수 없는 데이터 포맷입니다.");
		}

	}

	private static void printBookList(Vector<Book> bookList) {

		for (Book b : bookList) {
			System.out.println(b.toString());
		}

	}

	public static void main(String[] args) {

		Vector<Book> bookList = new Vector<Book>();

		try {

			bookList.add(makeBook("Java Programming 기초:컴퓨터:35000"));
			bookList.add(makeBook("초보자를 위한 SQL:컴퓨터:28000"));
			bookList.add(makeBook("HTML5API 소개:컴퓨터:58000"));
			// case1
			bookList.add(makeBook("JDBC Programming 기초:컴퓨터:45000"));
			// case2
			//bookList.add(makeBook("JDBC Programming 기초2:컴퓨터"));
			bookList.add(makeBook("JSP Programming 고급:컴퓨터:58000"));

			System.out.println("<< 책 목록 >>");
			BookTestApp.printBookList(bookList);

		} catch (DataFormatException e) {
			System.out.println(e.getMessage());
			
		} catch (NumberFormatException e1) {
			System.out.println("[usage]:: 책이름:장르:대여비용 ");
			e1.printStackTrace();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
