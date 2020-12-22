package com.laptrinhweb.service;
// retun tung dao 

import java.util.ArrayList;

import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.paging.Pageble;

public interface INewService {
	ArrayList<NewModel> findByCategoryId(Long CategoryID) throws ClassNotFoundException;
	NewModel save(NewModel news) throws ClassNotFoundException;
	NewModel update(NewModel updateNews) throws ClassNotFoundException;
	void delete (Long[] ids) throws ClassNotFoundException;
	ArrayList<NewModel> finAll(Pageble pageble) throws ClassNotFoundException;
	int getTotalitem() throws ClassNotFoundException;
//	ArrayList<NewModel> finAll(Integer offset,Integer limit ,String sortName,String sortBy) throws ClassNotFoundException;
}
