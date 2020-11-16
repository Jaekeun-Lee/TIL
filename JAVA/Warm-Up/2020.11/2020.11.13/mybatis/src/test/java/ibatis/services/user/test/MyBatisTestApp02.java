package ibatis.services.user.test;

import java.io.Reader;
import java.util.List;

import mybatis.service.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * FileName : MyBatisTestApp02.java
  */
public class MyBatisTestApp02 {
	
	///main method
	public static void main(String[] args) throws Exception{
		
		//==> 1. xml metadata 읽는 Stream 생성
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config02.xml");
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>     SqlSession을 생성하는 SqlSessionFactory  instance 생성
		SqlSessionFactory sqlSessionFactory 
											= new SqlSessionFactoryBuilder().build(reader);
		//==>3. SqlSessionFactory 를 통해 autoCommit true 인 SqlSession instance 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");
		
		//0. getUserList01 :: # 대입자를 이용한 like 연산자 검색 
		//									  ==> 검색결과 없는것 확인
		System.out.println(":: 0. user로시작하는 userId User(SELECT)  ? ");
		List<User> list = sqlSession.selectList("UserMapper02.getUserList01","user");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//1. getUserList01 :: # 대입자를 이용한 like 연산자 검색 
		//                         			  ==> 검색결과 존재 확인 :: %와일드카드 직접입력 
		System.out.println(":: 1. user로시작하는 userId User(SELECT)  ? ");
		list = sqlSession.selectList("UserMapper02.getUserList01","user%");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//2.  getUserList01 :: # 대입자를 이용한 like 연산자 검색 
		//									   ==> 검색결과 없는것 확인
		System.out.println(":: 2. 01로 끝나는 userId User(SELECT)  ? ");
		 list = sqlSession.selectList("UserMapper02.getUserList01","01");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//3. getUserList01 :: # 대입자를 이용한  like 연산자 검색 
		//						 			  ==> 검색결과 존재 확인 :: %와일드카드 직접입력
		System.out.println(":: 3. 01로 끝나는 userId User(SELECT)  ? ");
		list = sqlSession.selectList("UserMapper02.getUserList01","%01");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//4. getUserList02 :: $ 대입자를 이용한 like 연산자 검색
		//									  ==> 검색결과 존재 확인 
		System.out.println(":: 4. user 문자가 있는 userId User(SELECT)  ? ");
		list = sqlSession.selectList("UserMapper02.getUserList02","user");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//5. getUserList02 :: $ 대입자를 이용한 like 연산자 검색
		//									  ==> 검색결과 존재 확인 
		System.out.println(":: 5. 01 문자가 있는 userId User(SELECT)  ? ");
		 list = sqlSession.selectList("UserMapper02.getUserList02","01");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//6. getUserList01 / getUserList02 를 비교하여 #대입자 와
        // $대입자(직접 값 삽입)의 의미를 확인하자.  :: SQL 주입에 주의 필요 
		System.out.println(":: 6. # 대입자 / $ 대입자의 이해   ? ");
		String name = (String)sqlSession.
													selectOne("UserMapper02.findUser",
																"user_id = 'user01' and password = 'user01'");
		System.out.println(":: 6. findUser02(SELECT)  ? "+name);
		System.out.println("\n");
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
	}//end of main
}//end of class