package in.synxt.secureinventory.service;

import in.synxt.secureinventory.entities.InventoryUsers;

public interface InventoryUserService {
	public InventoryUsers loadUsername(String emailId);
}
