package ibatis.services.user.test;

import java.io.Reader;
import java.util.List;

import mybatis.service.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTestApp {

	/// main method
	public static void main(String[] args) throws Exception {
		// ==> mybatis-config.xml : MyBatis Framework 의 핵심 MetaData
		// ==> UserMapper.xml : SQL 를 갖는 MetaData

		// ==> 1. xml metadata 읽는 Stream 생성
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config.xml");
				
		// ==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한
		// ==> SqlSession을 생성하는 SqlSessionFactory instance 생성
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		// ==> 3. xml 에 등록된 query 수행 후 설정된 출력(?) 객체를 갖는 List 객체 받기
		List<User> list = sqlSession.selectList("UserMapper.getUserList");
		// ==> 3. SqlSession close
		sqlSession.close();
		/*
		 * //==>UserMapper.xml 에 등록,설정된 내용 <select id="getUserList"
		 * resultType="mybatis.service.domain.User"> SELECT user_id AS userId, user_name
		 * AS userName, password AS password, age AS age, grade AS grade, reg_date AS
		 * regDate FROM USERS </select>
		 */
		System.out.println("#####################################");
		System.out.println(":: 모든정보 출력");

		for (User user : list) {
			System.out.println(user.toString());
		}
		System.out.println("#####################################");
	}// end of main
}// end of class
/*
 * ■ MyBatisTestApp / JDBCTestApp 를 통한 MyBatis Framework 의 이해 ㅇ SQL,커넥션,트랜잭선 를
 * 메타데이타로 캡술화였으며, :: 참조 => mybatis-config.xml / UserMapper.xml ㅇ JDBC철차 :
 * Connection => Statement => ResultSet resource 관리 : close query 수행 결과 비지니스객체
 * 바인딩 JDBC API 를 사용하여 수행시 반복적으로 반드시 수행하는 일련의 과정을 수행함. :: 참조 =>List<User> list =
 * sqlSession.selectList("UserMapper.getUserList");
 * 
 * ■ MyBatis Framework 의 장점 ㅇ 작고 간단하다 (다른 라이브러리와 의존관계 없다. ) ㅇ SQL Mapper(Data
 * Mapper) =>SQL 과 비지니스객체 바인딩 ㅇ 생산성 / 성능 / 작업의 분배 (소스코드와 SQL 의 분리) ㅇ 관심사의 분리 (
 * DBMS 에 독립적인 API제공 및 JDBC API가 아닌 비지니스 객체만 가지고 작업)
 * 
 * ■ MyBatis Framework 은 JDBC 절차를 간결화 / JDBC 철차를 추상화 / 캡슐화한 lib
 */