package mybatis.service.user.test;

import java.io.Reader; 

import mybatis.service.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * FileName : MyBatisTestApp04.java
  */
public class MyBatisTestApp04 {
	
	///main method
	public static void main(String[] args) throws Exception{
		
		//==> 1. xml metadata 읽는 Stream 생성
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>     SqlSession을 생성하는 SqlSessionFactory  instance 생성
		SqlSessionFactory sqlSessionFactory 
											= new SqlSessionFactoryBuilder().build(reader);
		//==>3. SqlSessionFactory 를 통해 autoCommit true 인 SqlSession instance 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");
		
		//==> Test 용 user instance 생성 및 age / regData null setting
		User user = new User("user04","주몽","user04",null,0);
	
		//1. UserMapper04.addUser01 Test  :: users table age/grade/redDate 입력값 확인:NG 
		System.out.println(":: 1. addUser01(INSERT)  ? "
													+ sqlSession.insert("UserMapper04.addUser01",user));
		System.out.println("\n");
		
		//2. UserMapper04.addUser02 Test :: users table age/grade/redDate 입력값 확인:NG
		user.setUserId("user05");
		System.out.println(":: 2. addUser02(INSERT)  ? "
													+ sqlSession.insert("UserMapper04.addUser02",user));
		System.out.println("\n");
		
		//3. UserMapper04.addUer03 Test  :: users table age/grade/redDate 입력값 확인:OK
		user.setUserId("user06");
		//==> Dynamic SQL(?) 사용 처리 :: 추후 학습..	
		System.out.println(":: 3. addUser03(INSERT)  ? "
													+ sqlSession.insert("UserMapper04.addUser03",user));
		System.out.println("\n");
		
		//4. UserMapper04.addUser04 Test  :: users table age/grade/redDate 입력값 확인:OK
		user.setUserId("user07");
		//==> Dynamic SQL(?) 사용 처리 :: 추후 학습..
		System.out.println(":: 4. addUser04(INSERT)  ? "
													+ sqlSession.insert("UserMapper04.addUser04",user));
		System.out.println("\n");
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
	}//end of main
}//end of class
