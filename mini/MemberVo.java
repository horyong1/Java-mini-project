package project1st;

public class MemberVo {
	private String id;
	private String pwd;
	private String pwdck;
	private String name;
	private String tel;
	private String email;
	private String gender;
	private String birth;
	
	public MemberVo() {
		
	}
	
	
	public MemberVo(String id, String pwd, String pwdck, String name, String tel, String email, String gender,
			String birth) {
		
		this.id = id;
		this.pwd = pwd;
		this.pwdck = pwdck;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdck() {
		return pwdck;
	}

	public void setPwdck(String pwdck) {
		this.pwdck = pwdck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	

	
}
