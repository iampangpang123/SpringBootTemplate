package com.springboottemplate.mysql;

public class User2 {
	int uid;
	String username;
	String addrss;
	String sex;
	int no1;
	int no2;

	public User2() {
		super();
	}
	public User2(String username, String addrss, String sex, int no1, int no2) {
		super();

		this.username = username;
		this.addrss = addrss;
		this.sex = sex;
		this.no1 = no1;
		this.no2 = no2;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddrss() {
		return addrss;
	}
	public void setAddrss(String addrss) {
		this.addrss = addrss;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getNo1() {
		return no1;
	}
	public void setNo1(int no1) {
		this.no1 = no1;
	}
	public int getNo2() {
		return no2;
	}
	public void setNo2(int no2) {
		this.no2 = no2;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", addrss=" + addrss + ", sex=" + sex + ", no1=" + no1
				+ ", no2=" + no2 + "]";
	}


}
