package com.model2.mvc.service.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Search;


public class ProductDao {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass()+".setSqlSession() Call....");
		this.sqlSession = sqlSession;
	}

	public ProductDao() {
		System.out.println("::"+getClass()+".default Constructor Call....");
	}
	
	public int addProduct(Product product) throws Exception {
		return sqlSession.insert("ProductMapper.insertProduct",product);
	}

	public Product getProduct(int prodNo) throws Exception {
		return sqlSession.selectOne("ProductMapper.findProduct",prodNo);
	}

	public int updateProduct(Product product) throws Exception {
		return sqlSession.update("ProductMapper.updateProduct",product);
	}

	public List<Object> getProductList(Search search) throws Exception {
		return sqlSession.selectList("ProductMapper.getProductList",search);
	}

}
