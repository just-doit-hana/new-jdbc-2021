package com.laptrinhweb.dao;

import java.util.ArrayList;

import com.laptrinhweb.model.NewModel;

public interface INewDao extends GenericDao<NewModel> {
	ArrayList<NewModel> findByCategoryId(Long CategoryID) throws ClassNotFoundException;
	// tro ve id cua bai viet 
	Long save(NewModel news) throws ClassNotFoundException;
	NewModel  findOne(Long id) throws ClassNotFoundException;
	void update(NewModel update) throws ClassNotFoundException;
	void delete(long id) throws ClassNotFoundException;
	ArrayList<NewModel> findAll(Integer offset,Integer limit) throws ClassNotFoundException;
	int getTotalItem() throws ClassNotFoundException;
	
}
