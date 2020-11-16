package mybatis.service.user.test;

import mybatis.service.domain.User;

import org.apache.ibatis.session.SqlSession;

/*
 * FileName : MyBatisTestApp08.java  
  */
public class MyBatisTestApp08 {

	/// main method
	public static void main(String[] args) throws Exception {

		// ==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");

		// ==> Test 용 User instance 생성
		User user = new User("user01", "홍길동", "user01", new Integer(30), 1);

		// 1. UserMapper08.getUserList01 Test
		System.out.println(":: 1. getUserList01(SELECT)  ? ");
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList01", user));

		// 2. UserMapper08.getUserList01 Test
		System.out.println(":: 2. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList01", user));

		// 3. UserMapper08.getUserList01 Test
		System.out.println(":: 3. getUserList01(SELECT)  ? ");
		user.setUserName("홍길동");
		user.setAge(null);
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList01", user));

		// 4. UserMapper08.getUserList01 Test
		System.out.println(":: 4. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		user.setAge(null);
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList01", user));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n==================================\n");
		// ==> Test 용 User instance 생성 및 age / regData null setting
		user = new User("user04", "주몽", "user04", null, 0);

		// 0. UserMapper08.addUser Test :: users table age/grade/redDate 입력값 확인
		System.out.println(":: 0. addUser(INSERT)  ? " + sqlSession.insert("UserMapper08.addUser", user));
		System.out.println("\n");

		// 1. UserMapper08.getUserList02 Test
		System.out.println(":: 1. getUserList02(SELECT)  ? ");
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList02", user));

		// 2. UserMapper08.getUserList02 Test
		user.setUserId(null);
		System.out.println(":: 2. getUserList02(SELECT)  ? ");
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList02", user));

		// 3. UserMapper08.getUserList02 Test
		user.setPassword(null);
		user.setUserName(null);
		user.setGrade(1);
		System.out.println(":: 3. getUserList02(SELECT)  ? ");
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList02", user));

		// 4. UserMapper08.updateUser Test
		user.setUserId("user04");
		user.setPassword("0404");
		user.setAge(new Integer(100));
		user.setUserName(null);
		user.setGrade(1);
		// ==> 아래의 예제는 주석을 풀어가며 Test 하여, <SET> / <TRIM> 동일한 사용가능 확인할 것
		System.out.println(":: 4. updateUser(UPDATE)  ? " + sqlSession.update("UserMapper08.updateUser01", user));
		// + sqlSession.update("UserMapper08.updateUser02",user) );
		System.out.println("\n");

		// 5. UserMapper08.getUserList02 Test
		System.out.println(":: 5. getUserList02(SELECT)  ? ");
		SqlSessionFactoryBean.printList(sqlSession.selectList("UserMapper08.getUserList02", user));

		// 6. UserMapper08.removeUser Test
		System.out.println(":: 6. removeUser (DELETE)  ? " + sqlSession.delete("UserMapper08.removeUser", "user04"));
		System.out.println("\n");

		// END::SqlSession close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
	}// end of main
}// end of class