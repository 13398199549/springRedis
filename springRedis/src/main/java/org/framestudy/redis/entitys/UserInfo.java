package org.framestudy.redis.entitys;

import java.io.Serializable;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2319951788162598565L;
	public static final String OBJECT_KEY = "USER"; 
	
	private Long id;
	private String userName;
	private Integer age;
	private String password;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(Long id, String userName, Integer age, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", age=" + age + ", password=" + password + "]";
	}
	
	
    public String getKey() {  
        return getUserName();  
    }  
  
    public String getObjectKey() {  
        return OBJECT_KEY;  
    }
}
