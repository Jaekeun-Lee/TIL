package ibatis.services.user.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import mybatis.service.domain.User;

/*
 * FileName : JDBCTestApp06.java
 *   ㅇ JDBC 철차에 따라 DBMS users table  INSERT  ::  INSERT 시 NULL 처리
 *   ㅇ JDBC 철차에 따라 DBMS users table  SELECT ::  NULL 커럼의 Application 에서 처리  
 */
public class JDBCTestApp05 {
	
	//main method
	public static void main(String[] args) throws Exception{
		//DBMS 접근정보
		String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbuser ="ibatis";
		String dbpwd = "ibatis";
		//JDBC을 이용하기 위한 객체 생성
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		//==> Test 용 User instance 생성
		User user = new User("user04","주몽","user04",null,0);
		
		//1단계 connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(dburl,dbuser,dbpwd);
		
		//2단계 INSERT 및 SELECT 문 생성 
		//==> INSERT SQL
		StringBuffer  insertSQL = new StringBuffer();
		insertSQL.append("INSERT ");
		insertSQL.append("INTO USERS( user_id,user_name,password,age,grade,reg_date) ");
		insertSQL.append("VALUES(?,?,?,?,?,?) ");
		//==>SELECT SQL
		StringBuffer  selectSQL = new StringBuffer();
		selectSQL.append("SELECT ");
		selectSQL.append("user_id, user_name, password, age, grade, reg_date ");
		selectSQL.append("FROM USERS WHERE user_id=?");
		
		//3단계 INSET,SELECT 실행
		pStmt = con.prepareStatement( insertSQL.toString() );
		pStmt.setString(1, user.getUserId());
		pStmt.setString(2, user.getUserName());
		pStmt.setString(3, user.getPassword());
		/////////////// TABLE column NULL 입력 API의 이해 //////////////////
		pStmt.setNull(4,Types.INTEGER);	  	//==> NULL 입력처리
		pStmt.setNull(5,Types.NUMERIC); 	//==> NULL 입력처리
		pStmt.setNull(6, Types.DATE);			//==> NULL 입력처리 
	    //==>JDBC Driver 는 드라이버에 컬럼타입을 알려주지 않으면 컬럼타입을 알수 없다
		//==>JDBC API 는 DB table Field 의 데이터 타입을 명시하여 전달, null 입력
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
		int isInsert = pStmt.executeUpdate();
		//==> 실행시킨 SQL 확인 및 결과 확인
		System.out.println( "SQL :: "+ insertSQL.toString() );
		System.out.println("INSERT 유무 : "+isInsert);
		
		//==>SELECT SQL
		pStmt = con.prepareStatement( selectSQL.toString() );
		pStmt.setString(1, user.getUserId());
		rs = pStmt.executeQuery();
		//==> 실행시킨 SQL 확인
		System.out.println( "SQL :: "+ selectSQL.toString() );
		
		 //==> 1EA의 User 객체가 1EA의 user 정보를 갖는다 
		User vo = new User();
		
		if( rs.next() ){
			 vo.setUserId( rs.getString("user_id") );
			 vo.setUserName( rs.getString("user_name") );
			 vo.setPassword( rs.getString("password") );
			 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 //==> NULL 입력된 column  console 확인하면....
			 if(rs.getString("user_id").equals("user04")){
				 System.out.println("getObject(password) : "+rs.getObject("password"));
				 System.out.println("getString(password) : "+rs.getString("password"));
				 System.out.println("getObject(age) : "+rs.getObject("age"));
				 System.out.println("getInt(age) : "+rs.getInt("age"));
				 System.out.println("getObject(grade) : "+rs.getObject("grade"));
				 System.out.println("getInt(grade) : "+rs.getInt("grade"));
				 System.out.println("getObject(reg_date) : "+rs.getObject("reg_date"));
				 System.out.println("getTimestamp(reg_date) : "+rs.getTimestamp("reg_date"));
			 }
			 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 vo.setAge( rs.getInt("age") );
			 vo.setGrade( rs.getInt("grade") );
			 vo.setRegDate( rs.getTimestamp("reg_date"));
		 }
		//4단계 각 Resource 반납
		 rs.close();		 pStmt.close();		 con.close();
		System.out.println("#####################################");
		System.out.println(":: 회원정보 출력");
		//==> 아래의 출력결과와 DBMS에 select 결과를 확인하자...
		//==> Reference DataType / Primitive DataType 비교 하여 
		//==> TABLE   null 입력된 부분은 비지니스객체(VO)에 어떻게 바인딩되어 있는지 확인
		System.out.println( vo.toString() ) ;
		System.out.println("#####################################");
	}//end of main
}//end of class