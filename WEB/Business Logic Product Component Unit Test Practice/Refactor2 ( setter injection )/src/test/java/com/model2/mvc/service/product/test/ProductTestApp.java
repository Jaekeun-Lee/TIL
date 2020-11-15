package com.model2.mvc.service.product.test;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Search;
import com.model2.mvc.service.product.dao.ProductDao;

public class ProductTestApp {

	/// main method
	public static void main(String[] args) throws Exception {

		// ==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();

		// ==> ProductDao 생성 및 sqlSession instance setter injection
		ProductDao productDao = new ProductDao();
		productDao.setSqlSession(sqlSession);
		System.out.println("\n");

		// ==> Test 용 Product instance 생성
		Product product = new Product("2번 테스트 앱", "2번 테스트 앱 디테일", "20201114", 22222, "2번테스트앱사진", "0");
		System.out.println(product);

		//System.out.println(":: 1. addProduct(INSERT)  ? ");
		//System.out.println(":: " + productDao.addProduct(product));

		System.out.println(":: 2. findProduct(SELECT)  ? ");
		product.setProdNo(10032);
		System.out.println(":: " + productDao.getProduct(product.getProdNo()) + "\n");

		product.setProdName("2번테스트앱 수정테스트");
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		System.out.println(":: " + productDao.updateProduct(product) + "\n");

		System.out.println(":: 4. 수정 결과  ? ");
		System.out.println(":: " + productDao.getProduct(product.getProdNo()) + "\n");

		Search search = new Search();
		search.setStartRowNum(1);
		search.setEndRowNum(3);
		System.out.println(":: 5. getProductList(정렬기준 X)  ? ");
		SqlSessionFactoryBean.printList(productDao.getProductList(search));

		System.out.println(":: 6. getProductList(정렬기준 판매중 상품만 보기)  ? ");
		search.setOrderCondition("0");
		SqlSessionFactoryBean.printList(productDao.getProductList(search));
		
		System.out.println(":: 7. getProductList(정렬기준 배송중 상품만 보기)  ? ");
		search.setOrderCondition("1");
		SqlSessionFactoryBean.printList(productDao.getProductList(search));
		
		System.out.println(":: 8. getProductList(정렬기준 가격 높은순)  ? ");
		search.setOrderCondition("2");
		SqlSessionFactoryBean.printList(productDao.getProductList(search));
		
		System.out.println(":: 9. getProductList(정렬기준 가격 낮은순)  ? ");
		search.setOrderCondition("3");
		SqlSessionFactoryBean.printList(productDao.getProductList(search));
		
		// END::SqlSession close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();

	}// end of main
}// end of class