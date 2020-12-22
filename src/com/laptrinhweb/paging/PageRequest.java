package com.laptrinhweb.paging;

import com.laptrinhweb.sort.Sorter;

public class PageRequest implements Pageble {
	// TODO Auto-generated constructor stub

	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
//	nhan tu clinet la page , maxpageitem

	public PageRequest() {}
	public PageRequest(Integer page, Integer maxPageItem,Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
         this.sorter =sorter;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub

		return this.page;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		if (this.page != null && this.maxPageItem != null) {
			return (this.page - 1) * this.maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxPageItem() {
		return maxPageItem;
	}

	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		if (this.sorter != null) {
			return this.sorter;
		}
		return null;
	}
	

}
