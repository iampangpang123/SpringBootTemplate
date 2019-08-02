package com.springboottemplate.pojo;

public class User {
	private String id;
	private String email;
	private String password;
	private String name;
	private String area;
	private String college;
	private String grade;
	private String tel;
	private String qq;
	private String photo;
	private int point;
	private String state;
	private String statePhoto;
	private int probibit;
	
	
	
	public int getProbibit() {
		return probibit;
	}
	public void setProbibit(int probibit) {
		this.probibit = probibit;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatePhoto() {
		return statePhoto;
	}
	public void setStatePhoto(String statePhoto) {
		this.statePhoto = statePhoto;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public User(String id, String email, String password, String name, String area, String college, String grade,
			String tel, String qq, String photo, int point, String state, String statePhoto) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.area = area;
		this.college = college;
		this.grade = grade;
		this.tel = tel;
		this.qq = qq;
		this.photo = photo;
		this.point = point;
		this.state = state;
		this.statePhoto = statePhoto;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", area=" + area
				+ ", college=" + college + ", grade=" + grade + ", tel=" + tel + ", qq=" + qq + ", photo=" + photo
				+ ", point=" + point + ", state=" + state + ", statePhoto=" + statePhoto + ", probibit=" + probibit
				+ "]";
	}

	
}
