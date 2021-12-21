package com.example.demo.vo;

public class MemberVO {
	
	private String id,pw,pwd,email,nickname,age;	

	public MemberVO(String id, String pw,String pwd, String email, String nickname, String age) {
		setId(id);
		setPw(pw);
		setPwd(pwd);
		setNickname(nickname);
		setEmail(email);
		setAge(age);
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {		
		this.pw = pw;
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
		return "MemberVO [id=" + id + ", pw=" + pw + ", pwd=" + pwd + ", email=" + email
				+ ", nickname=" + nickname + ", age=" + age + "]";
	}
}