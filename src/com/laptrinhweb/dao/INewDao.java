package com.laptrinhweb.dao;

import java.util.ArrayList;

import com.laptrinhweb.model.NewModel;

public interface INewDao {
	ArrayList<NewModel> findByCategoryId(Long CategoryID);
}
