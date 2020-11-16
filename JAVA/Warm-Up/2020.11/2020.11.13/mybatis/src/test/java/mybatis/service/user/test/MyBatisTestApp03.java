package mybatis.service.user.test;

import java.io.Reader;
import java.util.List;

import mybatis.service.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * FileName : IBatisTestApp03.java
  */
public class MyBatisTestApp03 {
	
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
		
		//0.UserMapper03.getUserList Test
		System.out.println(":: 0. getUserList(SELECT)  ? ");
		List<User> list = sqlSession.selectList("UserMapper03.getUserList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//==> Test 용 User domain instance 생성
		User user = new User("user04","주몽","user04",40,4);
		
		//1.UserMapper03.addUser Test
		int insultResult = sqlSession.insert("UserMapper03.addUser", user);
		System.out.println(":: 1. addUser(INSERT)  result ? "+insultResult);
		System.out.println("\n");
		
		//2.UserMapper03.getUserList Test
		System.out.println(":: 2. getUserList(SELECT)  ? ");
		list = sqlSession.selectList("UserMapper03.getUserList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//3.UserMapper03.uadateUser Test
		user.setUserName("장보고");
		int updateResult = sqlSession.update("UserMapper03.updateUser", user);
		System.out.println(":: 3. updateUser(UPDATE) result ? "+updateResult);
		System.out.println("\n");
		
		//4.UserMapper03.getUserList Test
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		list = sqlSession.selectList("UserMapper03.getUserList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//5.UserMapper03.removeUser Test
		int deleteResult = sqlSession.delete("UserMapper03.removeUser", user.getUserId());
		System.out.println(":: 5. removeUser(DELETE) result ? "+deleteResult);
		System.out.println("\n");
		
		//6. UserMapper03.getUserList Test
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		list = sqlSession.selectList("UserMapper03.getUserList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
	}//end of main
}//end of class