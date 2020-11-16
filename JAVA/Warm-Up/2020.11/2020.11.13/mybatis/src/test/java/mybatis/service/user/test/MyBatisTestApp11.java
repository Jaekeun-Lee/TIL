package mybatis.service.user.test;

import java.util.ArrayList;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.impl.UserDaoImpl11;

import org.apache.ibatis.session.SqlSession;

/*
 * FileName : MyBatisTestApp11.java 
 *  :: Persistence Layer unit Test : MyBatis + DAO
  */
public class MyBatisTestApp11 {
	
	///main method
	public static void main(String[] args) throws Exception{

		//==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		
		//==> UserDaoImpl11 생성 및 sqlSession instance setter injection
		UserDaoImpl11 userDao = new UserDaoImpl11();
		userDao.setSqlSession(sqlSession);
		System.out.println("\n");
		
		//==> Test 용 User instance 생성  
		User user = new User("user04","주몽","user04",null,0);
		
		//1. addUser Test  
		System.out.println(":: 1. addUser(INSERT)  ? ");
		System.out.println(":: "+ userDao.addUser(user) );
		System.out.println("\n");
		
		//2. getUser Test :: 주몽 inert 확인 
		System.out.println(":: 2. getUser(SELECT)  ? ");
		System.out.println(":: "+ userDao.getUser(user.getUserId()) );
		System.out.println("\n");

		//3. uadateUser Test  :: 주몽 ==> 온달 수정
		user.setUserName("온달");
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+userDao.updateUser(user) );
		System.out.println("\n");
		
		//4. getUserList Test ::
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		Search search = new Search();
		search.setSearchCondition("userId");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("user04");
		search.setUserId( arrayList );
		
		System.out.println(":: List<User> 내용 : "+ userDao.getUserList(search) );
		System.out.println("\n");
		
		//5. removeUser Test
		System.out.println(":: 5. removeUser (DELETE)  ? ");
		System.out.println(":: "+userDao.removeUser(user.getUserId()) );
		System.out.println("\n");
		
		//6. getUserList Test 
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		System.out.println("List<User> 내용 : "+ userDao.getUserList(search) );
		System.out.println("\n");
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
	}//end of main
}//end of class