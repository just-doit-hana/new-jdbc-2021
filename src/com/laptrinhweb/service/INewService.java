package com.laptrinhweb.service;
// retun tung dao 

import java.util.ArrayList;

import com.laptrinhweb.model.NewModel;

public interface INewService {
	ArrayList<NewModel> findByCategoryId(Long CategoryID);
	NewModel save(NewModel news);
}
