package kr.co.board1.config;

public class SQL { //sql들 이렇게 모으면되는거 넘 깔끔하고
	
	// 회원관련
	public static final String SELECT_TERMS =  "SELECT * FROM `JSP_TERMS`;";
	public static  final String SELECT_USER = "SELECT  * FROM `JSP_USER` WHERE uid=? AND pass=PASSWORD(?);"; //PASSWORD 암호를 암호화해주는 함수
	public static final String INSERT_USER = "INSERT INTO `JSP_USER` SET " //public을 붙여서 사용할수있게하고 static을 붙여서 new를 안써도 register에서 사용할수있게함
																					+ "uid=?,"
																					+ "pass=PASSWORD(?),"
																					+ "name=?,"
																					+ "nick=?,"
																					+ "email=?,"
																					+ "hp=?,"
																					+ "zip=?,"
																					+ "addr1=?,"
																					+ "addr2=?,"
																					+ "regip=?,"
																					+ "rdate=NOW();";
																					
	public static final String SELECT_USER_COUNT="SELECT COUNT(*) FROM `JSP_USER` WHERE uid=?;"; //이렇게 하려면 무조건 preparedstatement로 써야함
	public static final String SELECT_NICK_COUNT="SELECT COUNT(*) FROM `JSP_USER` WHERE nick=?;"; 
	public static final String SELECT_EMAIL_COUNT="SELECT COUNT(*) FROM `JSP_USER` WHERE email=?;";
	public static final String SELECT_HP_COUNT="SELECT COUNT(*) FROM `JSP_USER` WHERE hp=?;"; 
	
	// 게시판관련
	public static final String INSERT_BOARD = "INSERT INTO `JSP_BOARD` SET "
																							+ "title=?,"
																							+ "content=?,"
																							+ "uid=?,"
																							+ "regip=?,"
																							+ "rdate=NOW();";
	public static final String SELECT_LIST = "SELECT a.*,b.nick FROM `JSP_BOARD` AS a "
																					+ "JOIN `JSP_USER` AS b ON a.uid=b.uid;"; 

	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `JSP_BOARD`;";
	
}
