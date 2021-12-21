package com.example.demo.vo;

public class MemberVO {
	

	private String memberID,password,pwd,email,nickname,age;	

	public MemberVO(String memberID, String password,String pwd, String email, String nickname, String age) {
		setMemberID(memberID);
		setPassword(password);
		setPwd(pwd);
		setNickname(nickname);
		setEmail(email);
		setAge(age);
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {		
		this.password = password;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberVO [memberID=" + memberID + ", password=" + password + ", pwd=" + pwd + ", email=" + email
				+ ", nickname=" + nickname + ", age=" + age + "]";
	}
}