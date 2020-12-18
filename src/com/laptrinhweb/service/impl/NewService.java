package com.laptrinhweb.service.impl;

import java.util.ArrayList;

import javax.inject.Inject;

import com.laptrinhweb.dao.INewDao;
import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.service.INewService;

public class NewService implements INewService {
@Inject
private INewDao newDao;
	@Override
	public ArrayList<NewModel> findByCategoryId(Long CategoryID) {
		// TODO Auto-generated method stub
		
		return newDao.findByCategoryId(CategoryID);
	}
	@Override
	public NewModel save(NewModel news) {
//		// TODO Auto-generated method stub
//		Long newID = newDao.save(news);
//		System.out.println(newID);
		Long newId= newDao.save(news);
		
		return newDao.findOne(newId);
	}
	
	// tren ui se khong co hien thi 2 cai thuoc tinh nay chi hien thi 4 cai kia 
	@Override
	public NewModel update(NewModel updateNews) {
		NewModel oldNews= newDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
        newDao.update(updateNews);
		return newDao.findOne(updateNews.getId());
	}

}
