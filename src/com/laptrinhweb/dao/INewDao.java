package com.laptrinhweb.dao;

import java.util.ArrayList;

import com.laptrinhweb.model.NewModel;

public interface INewDao extends GenericDao<NewModel> {
	ArrayList<NewModel> findByCategoryId(Long CategoryID);
}
