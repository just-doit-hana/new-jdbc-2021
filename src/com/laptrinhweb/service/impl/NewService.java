package com.laptrinhweb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.inject.Inject;

import com.laptrinhweb.dao.INewDao;
import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.service.INewService;

public class NewService implements INewService {
@Inject
private INewDao newDao;
	@Override
	public ArrayList<NewModel> findByCategoryId(Long CategoryID) throws ClassNotFoundException {
	
		
			// TODO Auto-generated method stub
			
			return newDao.findByCategoryId(CategoryID);
	
	}
	@Override
	public NewModel save(NewModel news) throws ClassNotFoundException {
//		// TODO Auto-generated method stub
//		Long newID = newDao.save(news);
//		System.out.println(newID);		
		news.setCreatedBy("");
		news.setCreatedDate(new Timestamp(System.currentTimeMillis())); // lay ngay hien tai cua he thong 
		Long newId= newDao.save(news);
		return newDao.findOne(newId);
	}
	// tren ui se khong co hien thi 2 cai thuoc tinh nay chi hien thi 4 cai kia 
	@Override
	public NewModel update(NewModel updateNews) throws ClassNotFoundException {
		NewModel oldNews= newDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("");
        newDao.update(updateNews);
		return newDao.findOne(updateNews.getId());
	}
	// co 2 truong hop chon 1 cai de xoa  va chon nhieu cai de xoa 
	@Override
	public void delete(Long[] ids) throws ClassNotFoundException {
		try {
			// TODO Auto-generated method stub
			//truoc khi xoa bai viet thi can xoa comment vi chua foreign  key  newid 
			for (long id : ids) {
				newDao.delete(id); // delete co nhieu truong hopj chay vong lap 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public ArrayList<NewModel> finAll() throws ClassNotFoundException {
		return newDao.findAll();
	}

}
