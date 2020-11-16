package mybatis.service.user.test;

import mybatis.service.domain.User;

import org.apache.ibatis.session.SqlSession;

/*
 * FileName : MyBatisTestApp07.java  
  */
public class MyBatisTestApp07 {
	
	///main method
	public static void main(String[] args) throws Exception{

		//==> SqlSessionFactoryBean 의 getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");
		
		//==> Test 용 User instance 생성  
		User user = new User("user01","홍길동","user01",new Integer(30),1);
	
		//1. UserMapper07.getUserList01 Test 
		System.out.println(":: 1. getUserList01(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList01",user) );
		
		//2. UserMapper07.getUserList01 Test 
		System.out.println(":: 2. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList01",user) );
		
		//3. UserMapper07.getUserList01 Test 
		System.out.println(":: 3. getUserList01(SELECT)  ? ");
		user.setUserName("홍길동");
		user.setAge(null);
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList01",user));
		
		//4. UserMapper07.getUserList01 Test 
		System.out.println(":: 4. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		user.setAge(null);
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList01",user) );
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n==================================\n");
		//==> Test 용 User instance 생성 및 age / regData null setting
		user = new User("user04","주몽","user04",null,0);
		user.setRegDate(null);
		
		//0. UserMapper07.addUser Test  :: users table age/grade/redDate 입력값 확인 
		System.out.println(":: 0. addUser(INSERT)  ? "
													+ sqlSession.insert("UserMapper07.addUser",user));
		System.out.println("\n");
		
		//1. UserMapper07.getUserList02 Test 
		System.out.println(":: 1. getUserList02(SELECT)  ? ");
		 SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList02",user) );
		
		//2. UserMapper07.getUserList02 Test 
		System.out.println(":: 2. getUserList02(SELECT)  ? ");
		user.setAge(new Integer(30));		
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList02",user) );
		
		//3. UserMapper07.getUserList02 Test 
		System.out.println(":: 3. getUserList02(SELECT)  ? ");
		user.setGrade(2);
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList02",user) );
		
		//4. UserMapper07.getUserList02 Test 
		System.out.println(":: 4. getUserList02(SELECT)  ? ");
		user.setAge(null);
		SqlSessionFactoryBean.printList( sqlSession.selectList("UserMapper07.getUserList02",user) );
		
		//5. UserMapper07.removeUser Test
		System.out.println(":: 5. removeUser (DELETE)  ? "
											+ sqlSession.delete("UserMapper07.removeUser",	user.getUserId()) );
		System.out.println("\n");
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
	}//end of main
}//end of class