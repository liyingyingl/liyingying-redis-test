package com.liyingying.bean;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	//id
	private int id;
	//姓名
	private String name;
	//性别
	private String gender;
	//电话
	private String phone;
	//邮箱
	private String email;
	//生日
	private String birthday;
	//无参构造
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	//重写toString方法
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	//get  set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
	

}
