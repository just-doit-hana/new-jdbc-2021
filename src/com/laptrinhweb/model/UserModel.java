package com.laptrinhweb.model;

//su khac biet giu java class va java bean la java class khong co get set con java bean co 
public class UserModel extends AbstractModel<UserModel> {
//	 authenrication la man hinh dang nhap  username pass 
//	authoriazation laf khi dang nhap thanh cong roi thi no re redrect sang trang theo phan quyen admin , customer
	private String userName;
	private String fullName;
	private String password;
	private int status;
	private Long roleId;
	private RoleModel role = new RoleModel();
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public UserModel() {
	}

	

	public UserModel(Long id, String userName, String fullName, String password, int status, Long roleId) {
		super();
	
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.status = status;
		this.roleId = roleId;
		
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

}
