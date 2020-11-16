package mybatis.service.user;

import java.util.List;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;

public interface UserService {
	
	//INSERT ( 회원 가입 )
		public int addUser(User user) throws Exception;
		
		//SELECT ( 회원 정보 검색 )
		public User getUser(String userId) throws Exception;
		
		//UPDATE ( 회원 정보 변경 )
		public int updateUser(User user) throws Exception;
		
		//DELETE ( 회원 정보 삭제 )
		public int removeUser(String userId) throws Exception;
		
		//회원 정보 리스트 검색
		public List<User> getUserList(Search search) throws Exception;
	
}
