package com.laptrinhweb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	private Long id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private Long[]ids;
	private List<T> listResultList = new ArrayList<>();
	// kkhong biet la cai gi ca  nos se phuj thuoc vao model laf gif  nen tren class se khai bao the T voo 
	
//	vi du 
//	 quan ly bai viet  -- >thi tra ve list<NewModel>
//	 quan ly comment  -- >thi tra ve list<CommentModel>
//	 quan ly ther laoi   -- >thi tra ve list<categoryModel>
	private int page ;
	private int maxPageItem;  // so item trong 1 page 
	private int  totalPage;
	private int  totalPageItem;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public List<T> getListResultList() {
		return listResultList;
	}
	public void setListResultList(List<T> listResultList) {
		this.listResultList = listResultList;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(int maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalPageItem() {
		return totalPageItem;
	}
	public void setTotalPageItem(int totalPageItem) {
		this.totalPageItem = totalPageItem;
	}
}
