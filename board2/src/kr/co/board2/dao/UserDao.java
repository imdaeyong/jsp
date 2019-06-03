package kr.co.board2.dao;

import java.sql.Connection;
import kr.co.board2.vo.UserVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import kr.co.board2.config.DBConfig;
import kr.co.board2.config.SQL;
import kr.co.board2.vo.TermsVO;

public class UserDao {

		//싱글톤 객체
		private static UserDao instance = new UserDao(); // 여기서 new를 해버린다면?
		
		private UserDao() {} //다른곳에서 new를 못하게함 !! 그냥 위의 service를 참조하면됨.
		public static  UserDao GetInstance() { // 외부에서 service( private라 참조못함) 를 사용할수있게 해주는 메소드
			return instance;
		}
		
		public TermsVO getTerms() throws Exception {
		
		//1단계,2단계
		Connection conn = DBConfig.getConnection();
		//3단계
		Statement stmt =  conn.createStatement();
		//4단계
		ResultSet rs = stmt.executeQuery(SQL.SELECT_TERMS);
		
		//5단계
		TermsVO vo = new TermsVO();
		if(rs.next() ) {
			vo.setTerms(rs.getString(1));
			vo.setPrivacy( rs.getString(2));
		}
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
		return vo; //두개의 리턴을 줄수가 없어서 vo생성
		
	}
		
		public void insertUser(UserVO vo) throws Exception {

			// 1단
			Connection conn = DBConfig.getConnection();

			// 3´Ü°è
			PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_USER);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getNick());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHp());
			psmt.setString(7, vo.getZip());
			psmt.setString(8, vo.getAddr1());
			psmt.setString(9, vo.getAddr2());
			psmt.setString(10, vo.getRegip());

			// 4´Ü°è
			psmt.executeUpdate();

			// 5´Ü°è
			// 6´Ü°è
			psmt.close();
			conn.close();
		}
		
		public int uidCheck(String uid) throws Exception {
			//1단계			//2단계
			Connection conn= DBConfig.getConnection();
			//3단계
			PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_USER_COUNT);
			psmt.setString(1, uid);
			//4단계
			ResultSet rs = psmt.executeQuery();
			//5단계
			int count = 0;
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			//6단계
			rs.close();
			psmt.close();
			conn.close();
				
			return count;
		}
}
