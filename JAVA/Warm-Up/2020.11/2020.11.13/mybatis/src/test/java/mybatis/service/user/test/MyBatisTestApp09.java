package mybatis.service.user.test;

import java.util.ArrayList;

import mybatis.service.domain.Search;

import org.apache.ibatis.session.SqlSession;

/*
 * FileName : IBatisTestApp09.java
  */
public class MyBatisTestApp09 {
	
	///main method
	public static void main(String[] args) throws Exception{
	
		//==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");

		System.out.println("\n==================================\n");
		//==> Test 용 Search instance 생성 
		Search search = new Search();
		
		//1. UserMapper09.getUserList01 Test 
		ArrayList<String> arrayList = new ArrayList<String>();
		search.setUserId( arrayList );
		System.out.println(":: 1. getUserList01(SELECT)  ? ");
		//==> 아래의 두 실행문 주석을 번갈아가며  1EA 씩 Test 하세요.
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper09.getUserList01",search) );
		//MyBatisTestUtil.printList( sqlSession.selectList("UserMapper09.getUserList03",search) );
		
		//2. UserMapper09.getUserList01 Test 
		arrayList.add("user01");
		arrayList.add("user02");
		System.out.println(":: 2. getUserList01(SELECT)  ? ");
		//==> 아래의 두 실행문 주석을 번갈아가며  1EA 씩 Test 하세요.
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper09.getUserList01",search) );
		//MyBatisTestUtil.printList( sqlSession.selectList("UserMapper09.getUserList03",search) );
		
		//3. UserMapper09.getUserList02 Test
		String [] userName = new String[2];
		search.setUserName(userName);
		System.out.println(":: 3. getUserList02(SELECT)  ? ");
		//==> 아래의 두 실행문 주석을 번갈아가며  1EA 씩 Test 하세요.
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper09.getUserList02",search) );
		//MyBatisTestUtil.printList( sqlSession.selectList("UserMapper09.getUserList04",search) );
		
		//4. UserMapper09.getUserList02 Test
		userName[ 0 ] = "홍길동iba";
		userName[ 1 ] = "주몽";
		search.setUserName(userName);
		System.out.println(":: 4. getUserList02(SELECT)  ? ");
		//==> 아래의 두 실행문 주석을 번갈아가며  1EA 씩 Test하세요.
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper09.getUserList02",search) );
		//MyBatisTestUtil.printList( sqlSession.selectList("UserMapper09.getUserList04",search) );
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
		
	}//end of main
}//end of class