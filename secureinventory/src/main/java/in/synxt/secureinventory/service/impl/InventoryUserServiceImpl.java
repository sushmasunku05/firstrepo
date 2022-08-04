package in.synxt.secureinventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.synxt.secureinventory.dao.InventoryUserDao;
import in.synxt.secureinventory.entities.InventoryUsers;
import in.synxt.secureinventory.service.InventoryUserService;

@Service
public class InventoryUserServiceImpl implements InventoryUserService{

	@Autowired
	private InventoryUserDao userDao;
	
	@Override
	public InventoryUsers loadUsername(String emailId) {
		return userDao.findByEmailId(emailId);
	}

}
