package com.example.demo.vo;

public class MemberVO {
	
<<<<<<< HEAD
	private String memberID,password,email,nickname,age;

	public MemberVO(String memberID, String password, String email, String nickname, String age) {
		setMemberID(memberID);
		setPassword(password);
		setEmail(email);
		setNickname(nickname);
=======
	private String id,pw,pwd,email,nickname,age;	

	public MemberVO(String id, String pw,String pwd, String email, String nickname, String age) {
		setId(id);
		setPw(pw);
		setPwd(pwd);
		setNickname(nickname);
		setEmail(email);
>>>>>>> master
		setAge(age);
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
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

=======
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id!=null && !id.equals("")) {
			this.id = id;
		}else {
			System.out.println("id를 확인하세요");
		}
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


>>>>>>> master
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

<<<<<<< HEAD
	public void setAge(String age) {
=======
	public void setAge(String phone) {
>>>>>>> master
		this.age = age;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "MemberVO [memberID=" + memberID + ", password=" + password + ", email=" + email + ", nickname="
				+ nickname + ", age=" + age + "]";
	}
	
	

=======
		return "MemberVO [id=" + id + ", pw=" + pw + ", pwd=" + pwd + ", email=" + email
				+ ", nickname=" + nickname + ", age=" + age + "]";
	}
>>>>>>> master
}