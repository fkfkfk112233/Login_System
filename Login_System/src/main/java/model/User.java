package model;

import java.time.LocalDateTime;

public class User {
	private int userId;
	private String account;
	private String password;
	private String name;
	private int roleId;
	private LocalDateTime create_time;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String account, String password, String name, int roleId, LocalDateTime createAt) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.roleId = roleId;
		this.create_time = createAt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int udrtId) {
		this.userId = udrtId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public LocalDateTime getCreateAt() {
		return create_time;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.create_time = createAt;
	}
	
	
}
