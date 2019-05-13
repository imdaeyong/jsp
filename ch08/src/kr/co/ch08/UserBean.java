package kr.co.ch08;
/*
 * form 태그 클래스
 */
public class UserBean {
	private String uid;
	private String name;
	private int gender; //string으로 받고 parseint해줘두댐
	private String[] hobby;
	private String addr;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String[] getHobby() {
		return hobby;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
