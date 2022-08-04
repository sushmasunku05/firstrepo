package in.synxt.secureinventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.synxt.secureinventory.entities.InventoryUsers;

@Repository
public interface InventoryUserDao extends JpaRepository <InventoryUsers,Integer>{
	public InventoryUsers findByEmailId(String emailId);
}
