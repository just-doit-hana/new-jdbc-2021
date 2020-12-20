package com.laptrinhweb.model;

public class RoleModel extends AbstractModel<RoleModel> {

	
	private String name;
	private String code;
	

	public RoleModel() {
	}

	public RoleModel(Long id, String name, String code) {
		super();
	
		this.name = name;
		this.code = code;
		
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

}
