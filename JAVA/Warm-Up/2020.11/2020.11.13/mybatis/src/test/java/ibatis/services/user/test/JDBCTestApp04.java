package ibatis.services.user.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

import mybatis.service.domain.User;

/*
 * FileName : JDBCTestApp04.java
 *   ㅇ JDBC 철차에 따라 DBMS users table  INSERT  ::  INSERT/UDATE 시 NULL 처리
 */
public class JDBCTestApp04 {
	
	//main method
	public static void main(String[] args) throws Exception{
		//DBMS 접근정보
		String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbuser ="ibatis";
		String dbpwd = "ibatis";
		//JDBC을 이용하기 위한 객체 생성
		Connection con = null;
		PreparedStatement pStmt = null;
		
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
				
		//3단계 INSET,SELECT 실행
		//==>INSET SQL
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
		
		//4단계 각 Resource 반납
		 pStmt.close();		 con.close();
		 
	}//end of main
}//end of class