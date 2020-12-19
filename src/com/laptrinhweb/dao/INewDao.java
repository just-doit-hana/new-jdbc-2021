package com.laptrinhweb.dao;

import java.util.ArrayList;

import com.laptrinhweb.model.NewModel;

public interface INewDao extends GenericDao<NewModel> {
	ArrayList<NewModel> findByCategoryId(Long CategoryID);
	// tro ve id cua bai viet 
	Long save(NewModel news);
	NewModel  findOne(Long id);
	void update(NewModel update);
	void delete(long id);
}
