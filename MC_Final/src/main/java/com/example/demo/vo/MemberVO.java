package com.example.demo.vo;

public class MemberVO {
	
	private String id,pw,nickname,email,age;

	public MemberVO(String id, String pw, String name, String email, String nickname, String age) {
		setId(id);
		setPw(pw);
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
		if(id!=null && !id.equals("")) {
			this.id = id;
		}else {
			System.out.println("id를 입력하세요");
		}
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		if(pw!=null && !pw.equals("")) {
			this.pw = pw;
		}else {
			System.out.println("pw를 입력하세요");
		}
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
		return "MemberVO [id=" + id + ", pw=" + pw + ", email=" + email
				+ ", nickname=" + nickname + ", age=" + age + "]";
	}
	
	

}
