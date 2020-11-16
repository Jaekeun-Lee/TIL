package mybatis.service.user.test;

import java.io.Reader;
import java.util.List;

import mybatis.service.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * FileName : MyBatisTestApp05.java
 * ㅇ 금번 예제는 아래와 같이 두번 Test 한다.
 * 		1. mybatis-config01.xml  <setting name="callSettersOnNulls" value="false"/>
 * 		2. mybatis-config01.xml  <setting name="callSettersOnNulls" value="true"/>
 *   변경후 각각 Test할 것.
 *   ㅇ JDBCTestApp05.java 를 실행하여 이해 할 것.
  */
public class MyBatisTestApp05 {

	/// main method
	public static void main(String[] args) throws Exception {

		// ==> 1. xml metadata 읽는 Stream 생성
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");

		// ==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한
		// ==> SqlSession을 생성하는 SqlSessionFactory instance 생성
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ==>3. SqlSessionFactory 를 통해 autoCommit true 인 SqlSession instance 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");

		// ==> Test 용 User instance 생성 및 age / regData null setting
		User user = new User("user04", "주몽", "user04", null, 0);
		user.setRegDate(null);

		// 1. UserMapper05.addUser Test :: users table age/grade/redDate 입력값 확인:OK
		System.out.println(":: 1. addUser(INSERT)  ? " + sqlSession.insert("UserMapper05.addUser", user));
		System.out.println("\n");

		// 2. UserMapper05.getUser01 Test :: users table age/grade/redDate 입력값 확인
		System.out.println(
				":: 2. getUser01(SELECT)  ? " + sqlSession.selectOne("UserMapper05.getUser", user.getUserId()));
		System.out.println("\n");

		// 3. UserMapper05.getUserList Test :: users table age/grade/redDate 입력값 확인
		System.out.println(":: 3. getUserList(SELECT)  ? ");
		List<User> list = sqlSession.selectList("UserMapper05.getUserList");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("<" + (i + 1) + "> 번째 회원.." + list.get(i).toString());
		}
		System.out.println("\n");

		// 4. UserMapper05.removeUser Test
		System.out.println(
				":: 4. removeUser (DELETE)  ? " + sqlSession.delete("UserMapper05.removeUser", user.getUserId()));
		System.out.println("\n");

		// END::SqlSession close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
	}// end of main
}// end of class